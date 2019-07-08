# Bilibili API library for Kotlin
本项目封装一些 Bilibili API 以方便在 Kotlin 中使用(也可用于其他 JVM 语言).
 
协议来自对 Bilibili Android APP 的逆向工程以及截包分析.

# 引入依赖
RestFul API
```groovy
compile group: 'com.hiczp', name: 'bilibili-api-rest', version: '0.2.0'
```

Websocket(用于连接直播间弹幕推送服务器以获取实时弹幕)
```groovy
compile group: 'com.hiczp', name: 'bilibili-api-websocket', version: '0.2.0'
```

# 获取直播间实时弹幕
举个例子
```kotlin
val liveClient = LiveClient(roomId = 23058) {
    resolvedPackets.consumeEach {
        when (it) {
            is CommandPacket -> {
                val command = it.content
                println("[${command.cmd}] $command")
            }
            is PopularityPacket -> {
                println("Popularity: ${it.content}")
            }
        }
    }
}
runBlocking {
    liveClient.connect()
}
```

`resolvedPackets` 是一个输送解析后的数据包的 `Channel`, 解析后的数据包有 `CommandPacket` 以及 `PopularityPacket` 两种类型.

`CommandPacket` 的本体是一段 JSON, 由于其内容经常发生改变, 所以不提供 POJO.

`Command.cmd` 是一个快捷方式, 可以快速取得其中的 `cmd` 字段从而判断其类别.

作为样本的 JSON 数据在本项目 `/record` 文件夹下.

大部分 JSON 都有光怪陆离的数据结构. 其中 `DANMU_MSG` 尤为恶劣, 通篇都是数组. 为了方便对其解析, 故提供内联类 `DanmakuMessage`.

使用方法如下

```kotlin
val command = commandPacket.content
val danmakuMessage = command.asDanmakuMessage()
with(danmakuMessage) {
    println("$nickname: $message")
}
```

`PopularityPacket` 的本体是一个 `Int` 数字, 表示当前房间的人气值. 该数据包每 30秒 收到一次.

如果要为读取操作设定超时, 可以设定为 40秒.

注意: 如果使用短房间号来连接弹幕推送服务器, 可能会得不到正确的人气值信息(一直为 0 或者一直为 1). 因此在连接弹幕推送服务器前应当首先获取直播间基本信息. 同时, 弹幕服务器不是唯一的, 在构造 `LiveClient` 时可以传入从房间基本信息中获取到的其他服务器地址.

# License
GPL V3
