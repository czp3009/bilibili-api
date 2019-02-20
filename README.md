# Bilibili API JVM 调用库
该项目提供 Bilibili API 的 JVM 调用, 协议来自 Bilibili Android APP 的逆向工程以及截包分析.

# 登录和登出
https://passport.bilibili.com

登陆和登出均为异步方法, 需要在协程上下文中执行.

    runBlocking {
        BilibiliClient().run {
            login(username, password)
            logout()
        }
    }

`login` 方法返回一个 `LoginResponse` 实例, 下次可以直接赋值到没有登陆的 `BilibiliClient` 实例中来恢复登陆状态.

    BilibiliClient().apply {
        this.loginResponse = loginResponse
    }

`LoginResponse` 继承 `Serializable`, 可被序列化.

如果登录操作失败, 将抛出 `BilibiliApiException`(只要服务器返回的 code 不为 0 都将抛出异常), 通过以下代码获取服务器返回的 `code`

    val code = bilibiliApiException.commonResponse.code

在登陆操作中, 如果服务器返回 `-105` 表明本次登陆需要验证码(通常是由于多次错误的登陆尝试导致的), 原始返回如下所示

    {"ts":1550569982,"code":-105,"data":{"url":"https://passport.bilibili.com/register/verification.html?success=1&gt=b6e5b7fad7ecd37f465838689732e788&challenge=9a67afa4d42ede71a93aeaaa54a4b6fe&ct=1&hash=105af2e7cc6ea829c4a95205f2371dc5"},"message":"验证码错误!"}

自行访问 `commonResponse.data.obj.url.string` 将打开一个极验弹窗, 通过验证码后再次调用登陆接口:

    login(username, password, challenge, secCode, validate)

`challenge` 为本次极验的唯一标识

`validate` 为极验返回值

`secCode` 为 `"$validate|jordan"`

注意, `BilibiliClient` 不能严格保证线程安全, 如果在登出的同时进行登录操作可能引发错误.

登陆后, 可以访问全部 API.

# message
https://message.bilibili.com

    BilibiliClient().messageAPI

消息通知有关的接口.

# app
https://app.bilibili.com

    BilibiliClient().appAPI

总站 API. 获取个人信息的完整示例如下:

    runBlocking {
        val bilibiliClient = BilibiliClient().apply {
            login(username, password)
        }
        val myInfo = bilibiliClient.appAPI.myInfo().await()
        println(myInfo)
    }

# av
https://api.vc.bilibili.com

    BilibiliClient().vcAPI

小视频.

# member
https://member.bilibili.com

    BilibiliClient().memberAPI

创作中心.

# License
GPL V3
