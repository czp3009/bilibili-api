# Bilibili API library for Kotlin
本项目封装一些 Bilibili API 以方便在 Kotlin 中使用(也可用于其他 JVM 语言).
 
协议来自对 Bilibili Android APP 的逆向工程以及截包分析.

# 引入依赖
RestFul API
```groovy
compile group: 'com.hiczp', name: 'bilibili-api-rest', version: '0.2.0'
```

Websocket(用于获取直播间实时弹幕)
```groovy
compile group: 'com.hiczp', name: 'bilibili-api-websocket', version: '0.2.0'
```

# RestFul API
大部分 API 都是 RestFul API.

`BilibiliClient` 是一个模拟的客户端, 内含登陆状态. 应持有其引用, 并在合适时执行 `close()`.

## 登陆
```kotlin
val bilibiliClient = BilibiliClient()
runBlocking {
    bilibiliClient.login(username, password)
}
```

`BilibiliClient.login` 会返回一个 `Credential` 实例. 将其序列化后保存. 下次可以直接使用这一凭证来恢复登陆状态

```kotlin
val bilibiliClient = BilibiliClient(credential)
```

多次错误的登陆将导致下一次登陆需要验证码(极验).

登陆失败将抛出 `LoginException` 异常, 其中包含服务器原始返回内容 `LoginResponse`.

## 登出
```kotlin
runBlocking {
    bilibiliClient.revoke()
}
```

`BilibiliClient.revoke` 返回已被注销的凭证, 或返回 `null` 当此 `BilibiliClient` 实例没有包含凭证时.

如果凭证是错误的, 将抛出 `RevokeException`.

# 获取直播间实时弹幕
直播间实时弹幕是一个 Websocket.

`LiveClient` 是一个模拟的 Websocket 客户端, 内含回调函数, 可以重复调用 `connect()` 函数.

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
if (command.cmd == "DANMU_MSG") {
    with(command.asDanmakuMessage()) {
        println("$nickname: $message")
    }
}
```

`PopularityPacket` 的本体是一个 `Int` 数字, 表示当前房间的人气值. 该数据包每 30秒 收到一次.

如果要为读取操作设定超时, 可以设定为 40秒.

注意: 如果使用短房间号来连接弹幕推送服务器, 可能会得不到正确的人气值信息(一直为 0 或者一直为 1). 因此在连接弹幕推送服务器前应当首先获取直播间基本信息. 同时, 弹幕服务器不是唯一的, 在构造 `LiveClient` 时可以传入其他服务器地址.

# License
Apache License 2.0
