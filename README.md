# Bilibili API 调用库
该项目提供 Bilibili API 的 Java 调用, 协议来自 Bilibili Android APP 的逆向工程以及截包分析.

由于B站即使更新客户端, 也会继续兼容以前的旧版本客户端, 所以短期内不用担心 API 失效的问题.

如果 API 存在遗漏或者错误, 欢迎提交 issue.

注意, 该项目使用 Bilibili Android 客户端协议, 与 Web 端的协议有差异, 不要提交 Web 端有关的 API.

# 添加依赖
//TODO 尚未提交至 Maven 仓库

# 使用
## RESTFul API
安全验证有关的 params 有三个

    access_key: 用户的凭证(一些 API 中也称它为 access_token)
    appkey: OAuth2 的客户端识别码
    sign: 根据其他 params 生成的一个有固定算法的验证参数

appKey 和 sign 已经封装, 所有请求都会自动添加它们.

部分 API 需要登录, 登录后所有请求都会自动加上 access_key.

由于B站 API 设计清奇, 一些显然不需要登录的 API 也需要登录, 所以所有 API 尽可能登陆后访问以免失败.

### 登录
使用账户名和密码作为登录参数

    BilibiliRESTAPI.login(String username, String password) throws IOException, LoginException
    
IOException 在网络故障时抛出

LoginException 在用户名密码不匹配时抛出

返回值为 LoginResponseEntity 类型, 可以记下其中的 accessToken 和 refreshToken, 如果有其他用途的话.

登出操作如下

    BilibiliRESTAPI.logout() throws IOException, LoginException

IOException 同上
LoginException 在 accessToken 错误时抛出(过期, 或者手动设置了一个错误的值)

当 accessToken 过期时, 需要刷新 token (OAuth2 协议中的 refreshToken 操作)

    BilibiliRESTAPI.refreshToken() throws IOException, LoginException

IOException 同上
LoginException 在 accessToken 和 refreshToken 不匹配时抛出(refreshToken 过期或者手动设置了错误的值)

### 普通 API
调用示例(打印一个直播间的历史弹幕)

    int roomId = 3;
    BilibiliRESTAPI.getLiveService()
                   .getHistoryBulletScreens(roomId)
                   .execute()
                   .body()
                   .getData()
                   .getRoom()
                   .forEach(liveHistoryBulletScreenEntity ->
                           System.out.printf("[%s]%s: %s\n",
                                   liveHistoryBulletScreenEntity.getTimeline(),
                                   liveHistoryBulletScreenEntity.getNickname(),
                                   liveHistoryBulletScreenEntity.getText())
                   );

API 文档

//TODO 文档编写中

## 进入直播间
由于弹幕推送是通过 Socket 实现的, 所以进入直播间并非是 REST 那样无状态的.

//TODO 尚未实现

# 已经实现的 API
## passport
获得 OAUth2 key

登录

获得 OAuth2 账户信息

刷新 Token

登出

## live
获得弹幕设置

获得直播间的历史弹幕(十条)

获得直播间信息

获得是否关注了目标主播

sendDaily(该 API 意义尚不明确)

获得所有类型的礼物数据

getAppSmallTV(意义不明)

获得所有头衔类型的数据

获得直播房间的特殊礼物

获得在 live.bilibili.com 的用户信息(与 bilibili 总站账户以及 OAuth2 的账户不一样)

获得直播间的播放地址(.flv 文件)

发送直播心跳包(可以获得观众经验)

发送弹幕

获得下一个宝箱的数据

开宝箱(得到银瓜子)

查看用户背包数据(可用的礼物)

获得活动礼物数据

发送礼物给主播

查看直播间的送礼排行榜

直播签到

# License
GPL V3
