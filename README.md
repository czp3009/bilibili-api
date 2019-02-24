# Bilibili API JVM 调用库
该项目提供 Bilibili API 的 JVM 调用, 协议来自 Bilibili Android APP 的逆向工程以及截包分析.

# 技术说明
`BilibiliClient` 类表示一个模拟的客户端, 实例化此类即表示打开了 Bilibili APP.

所有调用从这个类开始, 包括登陆以及访问其他各种 API.

使用协程来实现异步, 由于 [kotlin coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) 为编译器实现, 因此并非所有 JVM 语言都能正确调用 `suspend` 方法.

本项目尽可能的兼容其他 JVM 语言和 Android, 不要问, 问就没测试过.

`BilibiliClient` 实例化时会记录一些信息, 例如初始化的事件, 用于更逼真的模拟真实客户端发送的请求. 因此请不要每次都实例化一个新的 `BilibiliClient` 实例, 而应该保存其引用.

一个客户端下各种不同类型的 API (代理类)都是惰性初始化的, 并且只初始化一次, 因此不需要保存 API 的引用, 例如以下代码是被推荐的:

```kotlin
runBlocking {
    val bilibiliClient = BilibiliClient().apply {
        login(username, password)
    }
    val myInfo = bilibiliClient.appAPI.myInfo().await()
    val reply = bilibiliClient.mainAPI.reply(oid = 44154463).await()
}
```

如果一个请求的返回内容中的 `code`(code 是 BODY 的内容, 并非 HttpStatus) 不为 0, 将抛出异常 `BilibiliApiException`, 通过以下代码来获取服务器原始返回的 `code`:

```kotlin
val code = bilibiliApiException.commonResponse.code
```

一个错误返回的原始 `JSON` 如下所示:

```json
{
    "code": -629,
    "message": "用户名与密码不匹配",
    "ts": 1550730464
}
```

每种不同的 API 在错误时返回的 `code` 丰富多彩(确信), 可能是正数也可能是负数, 可能上万也可能是个位数, 不要问, 问就是你菜.

# 登录和登出
(Bilibili oauth2 v3)

登陆和登出均为异步方法, 需要在协程上下文中执行.

如果所使用的语言无法正确调用 `suspend` 方法, 可以使用 `loginFuture` 方法来替代, 它会返回一个 Java8 `CompletableFuture`.

`logoutFuture` 同理.

```kotlin
runBlocking {
    BilibiliClient().run {
        login(username, password)
        logout()
    }
}
```

`login` 方法返回一个 `LoginResponse` 实例, 下次可以直接赋值到没有登陆的 `BilibiliClient` 实例中来恢复登陆状态.

```kotlin
BilibiliClient().apply {
    this.loginResponse = loginResponse
}
```

`LoginResponse` 继承 `Serializable`, 可被序列化(JVM 序列化).

可能的错误返回有两种:

    -629 用户名与密码不匹配
    -105 验证码错误

如果仅使用用户名与密码进行登陆并且得到了 `-105` 的结果, 那么说明需要验证码(通常是由于多次错误的登陆尝试导致的).

原始返回如下所示

    {"ts":1550569982,"code":-105,"data":{"url":"https://passport.bilibili.com/register/verification.html?success=1&gt=b6e5b7fad7ecd37f465838689732e788&challenge=9a67afa4d42ede71a93aeaaa54a4b6fe&ct=1&hash=105af2e7cc6ea829c4a95205f2371dc5"},"message":"验证码错误!"}

自行访问 `commonResponse.data.obj.url.string` 打开一个极验弹窗, 完成滑动验证码后再次调用登陆接口:

```kotlin
login(username, password, challenge, secCode, validate)
```

`challenge` 为本次极验的唯一标识(在一开始给出的 url 中)

`validate` 为极验返回值

`secCode` 为 `"$validate|jordan"`

(注意, 极验会根据滑动的轨迹来识别人机, 所以要为最终用户打开一个 WebView 来进行真人操作而不能自动完成. 极验最终返回的是一个 jsonp, 里面包含以上三个参数, 详见极验接入文档).

注意, `BilibiliClient` 不能严格保证线程安全, 如果在登出的同时进行登录操作可能引发错误.

登陆后, 可以访问全部 API.

# 访问 API
通常的 API 访问是这样的

```kotlin
val myInfo = bilibiliClient.appAPI.myInfo().await()
```

不要问文档, 用自动补全(心)来感受.

# License
GPL V3
