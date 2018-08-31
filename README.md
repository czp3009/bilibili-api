# Bilibili API 调用库
该项目提供 Bilibili API 的 Java 调用, 协议来自 Bilibili Android APP 的逆向工程以及截包分析.

由于B站即使更新客户端, 也会继续兼容以前的旧版本客户端, 所以短期内不用担心 API 失效的问题.

对于一些 Bilibili Android APP 上没有的功能, 可以先[将 token 转换为 cookie](#sso), 然后再去调用 Bilibili Web API.

# API 不完全
由于本项目还在开发初期, 大量 API 没有完成, 所以很可能没有你想要的 API.

欢迎提交 issue 或者 Merge Request.

# 添加依赖
## Gradle

    compile group: 'com.hiczp', name: 'bilibili-api', version: '0.0.20'

# 名词解释
B站不少参数都是瞎取的, 并且不统一, 经常混用, 以下给出一些常见参数对应的含义

| 参数 | 含义 |
| :--- | :--- |
| mid | 用户 ID(与 userId 含义一致, 经常被混用) |
| userId | 用户 ID, 用户在B站的唯一标识, 数字 |
| uid | 用户 ID, 与 userId 同义 |
| userid | 注意这里是全小写, 它的值可能是 'bili_1178318619', 这个东西是没用的, B站并不用这个作为用户唯一标识 |
| showRoomId | 直播间 URL (Web)上的房间号(可能是一个很小的数字, 低于 1000) |
| roomId | 直播间的真实 ID(直播房间号在 1000 以下的房间, 真实 ID 是另外一个数字) |
| cid | 直播间 ID(URL 上的短房间号以及真实房间号都叫 cid) |
| ruid | 直播间房主的用户 ID |
| rcost | 该房间内消费的瓜子数量 |

(上表仅供其他开发者参照, 本调用库中已经封装为 Java 标准全写小驼峰命名法, 例如 userId, roomId, roomUserId)

# 使用
## RESTFul API
由于B站 API 设计清奇, 一些显然不需要登录的 API 也需要登录, 所以所有 API 尽可能登陆后访问以免失败.

### 登录
使用账户名和密码作为登录参数

    String username = "yourUsername";
    String password = "yourPassword";
    BilibiliAPI bilibiliAPI = new BilibiliAPI();
    LoginResponseEntity loginResponseEntity = bilibiliAPI.login(String username, String password);

IOException 在网络故障时抛出

LoginException 在用户名密码不匹配时抛出

CaptchaMismatchException 在验证码不正确时抛出, 见下文 [验证码问题](#验证码问题) 一节

login 方法的返回值为 LoginResponseEntity 类型, 使用

    BilibiliAccount bilibiliAccount = loginResponseEntity.toBilibiliAccount();

来获得一个 BilibiliAccount 实例, 其中包含了 OAuth2 的用户凭证, 如果有需要, 可以将其持久化保存.

将一个登陆状态恢复出来(从之前保存的 BilibiliAccount 实例)使用如下代码

    BilibiliAPI bilibiliAPI = new BilibiliAPI(BilibiliAccount bilibiliAccount);

注意, 如果这个 BilibiliAccount 实例含有的 accessToken 是错误的或者过期的, 需要鉴权的 API 将全部 401.

### 刷新 Token
OAuth2 的重要凭证有两个, token 与 refreshToken, token 到期之后, 并不需要再次用用户名密码登录一次, 仅需要用 refreshToken 刷新一次 token 即可(会得到新的 token 和 refreshToken, refreshToken 的有效期不是无限的. B站的 refreshToken 有效期不明确).

    bilibiliAPI.refreshToken();

IOException 在网络故障时抛出

LoginException 在 token 错误,或者 refreshToken 错误或过期时抛出.

refreshToken 操作在正常情况下将在服务器返回 401(实际上 B站 不用 401 来表示未登录)时自动进行, 因此 BilibiliAPI 内部持有的 BilibiliAccount 的实例的内容可能会发生改变, 如果需要在应用关闭时持久化用户 token, 需要这样来取得最后的 BilibiliAccount 状态

    BilibiliAccount bilibiliAccount = bilibiliAPI.getBilibiliAccount();

### 登出

    bilibiliAPI.logout();

IOException 在网络故障时抛出

LoginException 在 accessToken 错误或过期时抛出

### 验证码问题
当对一个账户在短时间内(时长不明确)尝试多次错误的登录(密码错误)后, 再尝试登录该账号, 会被要求验证码.

此时登录操作会抛出 CaptchaMismatchException 异常, 表示必须调用另一个接口

    public LoginResponseEntity login(String username,
                                     String password,
                                     String captcha,
                                     String cookie) throws IOException, LoginException, CaptchaMismatchException

这个接口将带 captcha 参数地去登录, 注意这里还有一个 cookie 参数.

下面先给出一段正确使用该接口的代码, 随后会解释其步骤

    String username = "yourUsername";
    String password = "yourPassword";
    BilibiliAPI bilibiliAPI = new BilibiliAPI();
    try {
        bilibiliAPI.login(username, password);
    } catch (CaptchaMismatchException e) {  //如果该账号现在需要验证码来进行登录, 就会抛出异常
        cookie = "sid=123456";    //自己造一个 cookie 或者从服务器取得
        Response response = bilibiliAPI.getCaptchaService()
                .getCaptcha(cookie)
                .execute();
        InputStream inputStream = response.body().byteStream();
        String captcha = letUserInputCaptcha(inputStream);  //让用户根据图片输入验证码
        bilibiliAPI.login(
            username,
            password,
            captcha,
            cookie
        );
    }

验证码是通过访问 https://passport.bilibili.com/captcha 这个地址获得的.

访问这个地址需要带有一个 cookie, cookie 里面要有 "sid=xxx", 然后服务端会记录下对应关系, 也就是 sid xxx 对应验证码 yyy, 然后就可以验证了.

我们会发现, 访问任何 passport.bilibili.com 下面的地址, 都会被分发一个 cookie, 里面带有 sid 的值. 我们访问 /captcha 也会被分发一个 cookie, 但是这个通过访问 captcha 而被分发得到的 cookie 和访问得到的验证码图片, 没有对应关系. 推测是因为 cookie 的发放在请求进入甚至模块运行完毕后才进行.

所以我们如果不带 cookie 去访问 /captcha, 我们这样拿到的由 /captcha 返回的 cookie 和 验证码, 是不匹配的.

所以我们要先从其他地方获取一个 cookie.

我们可以用 /api/oauth2/getKey(获取加密密码用的 hash 和公钥) 来获取一个 cookie

    String cookie = bilibiliAPI.getPassportService()
        .getKey()
        .execute()
        .headers()
        .get("Set-cookie");

/captcha 不验证 cookie 正确性, 我们可以直接使用假的 cookie (比如 123456)对其发起验证码请求, 它会记录下这个假的 cookie 和 验证码 的对应关系, 一样能验证成功. 但是不推荐这么做.

简单地说, 只要我们是带 cookie 访问 /captcha 的, 那么我们得到的验证码, 是和这个 cookie 绑定的. 我们接下去用这个 cookie 和 这个验证码的值 去进行带验证码的登录, 就可以成功登陆.

至于验证码怎么处理, 可以显示给最终用户, 让用户来输入, 或者用一些预训练模型自动识别验证码.

这个带验证码的登录接口也会继续抛出 CaptchaMismatchException, 如果验证码输入错误的话.

### SSO
通过 SSO API 可以将 accessToken 转为 cookie, 用 cookie 就可以访问 B站 的 Web API.

B站客户端内置的 WebView 就是通过这种方式来工作的(WebView 访问页面时, 处于登录状态).

首先, 我们需要登录

    String username = "yourUsername";
    String password = "yourPassword";
    BilibiliAPI bilibiliAPI = new BilibiliAPI();
    bilibiliAPI.login(String username, String password);

通过

    bilibiliAPI.toCookies();

来得到对应的 cookies, 类型为 Map<String, List\<Cookie>>, key 为 domain(可能是通配类型的, 例如 ".bilibili.com"), value 为此 domain 对应的 cookies.

如果只想得到用于进行 SSO 操作的那条 URL, 可以这么做

    String goUrl = "https://account.bilibili.com/account/home";
    bilibiliAPI.getSsoUrl(goUrl);

返回值是一个 HttpUrl, 里面 url 的值差不多是这样的

    https://passport.bilibili.com/api/login/sso?access_key=c3bf6002bd2e539f5bfce56308f14789&appkey=1d8b6e7d45233436&build=515000&gourl=https%3A%2F%2Faccount.bilibili.com%2Faccount%2Fhome&mobi_app=android&platform=android&ts=1520079995&sign=654e2d00aa827aa1d7acef6fbeb9ee70

如果 access_key 是正确的话, 这个 url 访问一下就登录 B站 了.

如果想跟 B站 客户端一样弄一个什么内嵌 WebView 的话, 这个 API 就可以派上用场(只需要在 WebView 初始化完毕后让 WebView 去访问这个 url, 就登陆了)(goUrl 可以是任意值, 全部的 302 重定向完成后将进入这个地址, 如果 goUrl 不存在或为空则将跳转到B站首页).

### Web API
上文讲到, 通过 SSO API, 可以将 token 转为 cookie, 在本项目中, Web API 封装在 BilibiliWebAPI 中, 可以通过如下方式得到一个已经登录了的 BilibiliWebAPI 实例

    String username = "yourUsername";
    String password = "yourPassword";
    BilibiliAPI bilibiliAPI = new BilibiliAPI();
    bilibiliAPI.login(String username, String password);
    BilibiliWebAPI bilibiliWebAPI = bilibiliAPI.getBilibiliWebAPI();

IOException 在网络错误时抛出(获取 cookie 时需要进行网络请求)

如果将之前的 bilibiliAPI.toCookies() 的返回值(cookiesMap)持久化了下来的话, 下次可以通过以下方式直接获得一个已经登录了的 BilibiliWebAPI 实例(注意, cookie 没有 refreshToken 机制, 过期不会自动刷新, 因此不推荐持久化 cookie)

    Map<String, List<Cookie>> cookiesMap = bilibiliAPI.toCookies();
    //序列化后存储
    //...
    //反序列化后得到上次存储的 cookiesMap
    BilibiliWebAPI bilibiliWebAPI = new BilibiliWebAPI(cookiesMap);

有了 BilibiliWebAPI 实例之后, 通过类似以下代码的形式来获取对应的 Service, API 调用方法和基于 Token 方式的 API 一致

    LiveService liveService = bilibiliWebAPI.getLiveService();

(这个 LiveService 是 Web API 里的 LiveService)

由于 Web API 是有状态的, 每个 BilibiliWebAPI 内部维护的 CookieJar 是同一个, 一些验证有关的 API 可能会改变 cookie.

通过以下代码来获得一个 BilibiliWebAPI 中目前持有的 CookieJar 的引用

    bilibiliWebAPI.getCookieJar();

### API 调用示例
打印一个直播间的历史弹幕

    long roomId = 3;
    new BilibiliAPI()
        .getLiveService()
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

签到

    String username = "yourUsername";
    String password = "yourPassword";
    BilibiliAPI bilibiliAPI = new BilibiliAPI();
    bilibiliAPI.login(username, password);
    bilibiliAPI.getLiveService()
        .getSignInfo()
        .execute();

发送一条弹幕到指定直播间

    long roomId = 3;
    String username = "yourUsername";
    String password = "yourPassword";
    BilibiliAPI bilibiliAPI = new BilibiliAPI();
    bilibiliAPI.login(username, password);
    
    bilibiliAPI.getLiveService()
        .sendBulletScreen(
            new BulletScreenEntity(
                    roomId,
                    bilibiliAPI.getBilibiliAccount().getUserId(),   //实际上并不需要包含 mid 就可以正常发送弹幕, 但是真实的 Android 客户端确实发送了 mid
                    "这是自动发送的弹幕"
            )
        )
        .execute();

(如果要调用需要鉴权的 API, 需要先登录)

API 文档

//TODO 文档编写中

## Socket
### 获取直播间实时弹幕

    long roomId = 3;
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    LiveClient liveClient = new BilibiliAPI()
        .getLiveClient(eventLoopGroup, roomId)
        .registerListener(new MyListener())
        .connect();

.connect() 会抛出 IOException 当网络故障时.

(connect 是阻塞的)

使用 .getLiveClient() 前可以先登录也可以不登陆直接用, 如果 API 已经登录, 那么进房数据包中会带有用户ID, 尚不明确有什么作用, 可能与一些统计有关.

多个 LiveClient 可以复用同一个 EventLoopGroup.

(connect 方法运行结束只代表 socket 确实是连上了, 但是服务器还没有响应进房请求数据包)

(当服务器响应进房请求数据包时才代表真的连上了, 此时会有一个连接成功的事件, 见下文)

事件机制使用 Google Guava EventBus 实现, 监听器不需要继承任何类或者接口.

    public class MyListener {
        @Subscribe
        public void onConnectSucceed(ConnectSucceedEvent connectSucceedEvent) {
            //do something
        }
        
        @Subscribe
        public void onConnectionClose(ConnectionCloseEvent connectionCloseEvent) {
            //do something
        }
        
        @Subscribe
        public void onDanMuMsg(DanMuMsgPackageEvent danMuMsgPackageEvent) {
            DanMuMsgEntity danMuMsgEntity = danMuMsgPackageEvent.getEntity();
            System.out.pintf("%s: %s\n", danMuMsgEntity.getUsername(), danMuMsgEntity.getMessage());
        }
    }

如果持续 40 秒(心跳包为 30 秒)没有收到任何消息, 将视为掉线, 会跟服务器主动断开连接一样(这通常是发送了服务器无法读取的数据包)触发一次 ConnectionCloseEvent.

    liveClient.closeChannel();

即可阻塞关闭连接.

    liveClient.closeChannelAsync();

即可异步关闭连接.

    eventLoopGroup.shutdownGracefully();

即可关闭事件循环, 结束 Nio 工作线程(所有使用这个 EventLoopGroup 的 LiveClient 也将在此时被关闭).

如果需要在直播间发送弹幕可以直接使用如下代码(需要先登录)

    String message = "这是一条弹幕";
    liveClient.sendBulletScreen(message);

所有的事件(有些数据包我也不知道它里面的一些值是什么含义, /record 目录下面有抓取到的 Json, 可以用来查看):

| 事件 | 抛出条件 | 含义 |
| :--- | :--- | :--- |
| ActivityEventPackageEvent | 收到 ACTIVITY_EVENT 数据包 | 活动事件 |
| ChangeRoomInfoPackageEvent | 收到 CHANGE_ROOM_INFO 数据包 | 更换房间背景图片 |
| ComboEndPackageEvent | 收到 COMBO_END 数据包 | 礼物连发结束 |
| ComboSendPackageEvent | 收到 COMBO_SEND 数据包 | 礼物连发开始 |
| ConnectionCloseEvent | 连接断开(主动或被动) | |
| ConnectSucceedEvent | 进房成功 | |
| CutOffPackageEvent | 收到 CUT_OFF 数据包 | 被 B站 管理员强制中断 |
| DanMuMsgPackageEvent | 收到 DANMU_MSG 数据包 | 弹幕消息 |
| EntryEffectPackageEvent | 收到 ENTRY_EFFECT 数据包 | 尚不明确 |
| EventCmdPackageEvent | 收到 EVENT_CMD 数据包 | 尚不明确 |
| GuardBuyPackageEvent | 收到 GUARD_BUY 数据包 | 船票购买 |
| GuardLotteryStartPackageEvent | 收到 GUARD_LOTTERY_START 数据包 | 船票购买后的抽奖活动 |
| GuardMsgPackageEvent | 收到 GUARD_MSG 数据包 | 舰队消息(登船) |
| LivePackageEvent | 收到 LIVE 数据包 | 开始直播 |
| NoticeMsgPackageEvent | 收到 NOTICE_MSG 数据包 | 获得大奖的通知消息 |
| PkAgainPackageEvent | 收到 PK_AGAIN 数据包 | 下面几个都是 PK 有关的事件 |
| PkClickAgainPackageEvent | 收到 PK_CLICK_AGAIN 数据包 |
| PkEndPackageEvent | 收到 PK_END 数据包 |
| PkInviteFailPackageEvent | 收到 PK_INVITE_FAIL 数据包 |
| PkInviteInitPackageEvent | 收到 PK_INVITE_INIT 数据包 |
| PkInviteSwitchClosePackageEvent | 收到 PK_INVITE_SWITCH_CLOSE 数据包 |
| PkInviteSwitchOpenPackageEvent | 收到 PK_INVITE_SWITCH_OPEN 数据包 |
| PkMatchPackageEvent | 收到 PK_MATCH 数据包 |
| PkMicEndPackageEvent | 收到 PK_MIC_END 数据包 |
| PkPrePackageEvent | 收到 PK_PRE 数据包 |
| PkProcessPackageEvent | 收到 PK_PROCESS 数据包 |
| PkSettlePackageEvent | 收到 PK_SETTLE 数据包 |
| PkStartPackageEvent | 收到 PK_START 数据包 |
| PreparingPackageEvent | 收到 PREPARING 数据包 | 停止直播 |
| RaffleEndPackageEvent | 收到 RAFFLE_END 数据包 | 抽奖结束(小奖, 通常是不定期活动) |
| RaffleStartPackageEvent | 收到 RAFFLE_START 数据包 | 抽奖开始(小奖) |
| ReceiveDataPackageDebugEvent | 该事件用于调试, 收到任何 Data 数据包时都会触发 | |
| RoomAdminsPackageEvent | 收到 ROOM_ADMINS 数据包 | 房管变更 |
| RoomBlockMsgPackageEvent | 收到 ROOM_BLOCK_MSG 数据包 | 房间黑名单(房间管理员添加了一个用户到黑名单) |
| RoomLockPackageEvent | 收到 ROOM_LOCK 数据包 | 房间被封 |
| RoomRankPackageEvent | 收到 ROOM_RANK 数据包 | 小时榜 |
| RoomShieldPackageEvent | 收到 ROOM_SHIELD 数据包 | 房间屏蔽 |
| RoomSilentOffPackageEvent | 收到 ROOM_SILENT_OFF 数据包 | 房间结束禁言 |
| RoomSilentOnPackageEvent | 收到 ROOM_SILENT_ON 数据包 | 房间开启了禁言(禁止某一等级以下的用户发言) |
| SendGiftPackageEvent | 收到 SEND_GIFT 数据包 | 送礼 |
| SendHeartBeatPackageEvent | 每次发送心跳包后触发一次 | |
| SpecialGiftPackageEvent | 收到 SPECIAL_GIFT 数据包 | 节奏风暴(20 倍以下的)(只在对应房间内有, 不会全站广播) |
| SysGiftPackageEvent | 收到 SYS_GIFT 数据包 | 系统礼物(20 倍以上节奏风暴, 活动抽奖等) |
| SysMsgPackageEvent | 收到 SYS_MSG 数据包 | 系统消息(小电视等) |
| TVEndPackageEvent | 收到 TV_END 数据包 | 小电视抽奖结束(大奖的获得者信息) |
| TVStartPackageEvent | 收到 TV_START 数据包 | 小电视抽奖开始 |
| UnknownPackageEvent | B站新增了新种类的数据包, 出现此情况请提交 issue | |
| ViewerCountPackageEvent | 收到 房间人数 数据包(不是 Json) | |
| WarningPackageEvent | 收到 WARNING 数据包 | 警告信息 |
| WelcomeActivityPackageEvent | 收到 WELCOME_ACTIVITY 数据包 | 欢迎(活动) |
| WelcomePackageEvent | 收到 WELCOME 数据包 | 欢迎(通常是 VIP) |
| WelcomeGuardPackageEvent | 收到 WELCOME_GUARD 数据包 | 欢迎(舰队) |
| WishBottlePackageEvent | 收到 WISH_BOTTLE 数据包 | 许愿瓶 |

事件里面可以取到解析好的 POJO, 然后可以从里面取数据, 见上面的监听器示例.

# 特别说明
## DANMU_MSG 中的各个字段含义
在直播间实时弹幕推送流中, 存在一种类型为 DANMU_MSG 的数据包, 它里面存储的 JSON, 全部都是 JsonArray, 并且每个元素类型不一样, 含义不一样.

简单地说, 这个 JSON 完全无法自描述而且很多字段猜不到是什么含义, 它的示例见 /record 文件夹(还有一份带备注的版本, 里面记录了已经猜出的字段含义).

已经猜出的字段, 可以直接从 DanMuMsgEntity 里面用对应的方法取得, 对于没有猜出的字段, 需要类似这样来获取:

    int something = danMuMsgEntity.getInfo().get(0).getAsJsonArray().get(2).getAsInt();

如果你可以明确其中的字段含义, 欢迎提交 issue.

## 直播间 ID 问题
一个直播间, 我们用浏览器去访问它, 他可能是这样的

    http://live.bilibili.com/3
    
我们可能会以为后面的 3 就是这个直播间的 room_id, 其实并不是.

我们能直接看到的这个号码, 其实是 show_room_id.

所有直播间号码小于 1000 的直播间, show_room_id 和 room_id 是不相等的(room_id 在不少 API 里又叫 cid).

一些 API 能提供自动跳转功能, 也就是用这个 show_room_id 作为参数, 返回的信息是跳转到对应的 room_id 之后的返回信息.

简单地说, 一些 API 用 show_room_id 作为参数可以正常工作, 而另一些不能. 所以尽可能使用 room_id 作为参数来调用 API.

room_id 的获取要通过

    http://api.live.bilibili.com/AppRoom/index?room_id=3&platform=android

其中, response.data.room_id 就是其真实的 room_id, 例子中的这个直播间的真实 room_id 为 23058

在代码中我们这样做

    long showRoomId = 3;
    long roomId = bilibiliAPI.getLiveService()
                    .getRoomInfo(showRoomId)
                    .execute()
                    .body()
                    .getData()
                    .getRoomId();

由此, 我们获得了直播间的真实 room_id, 用它访问其他 API 就不会出错了.

## 服务器返回非 0 返回值时
当服务器返回的 JSON 中的 code 字段非 0 时(有错误发生), 该 JSON 可能是由服务端过滤器统一返回的, 因此其 JSON 格式(字段类型)将和实体类不一样, 此时会导致 JsonParseErrorException.

为了让调用代码不需要写很多 try catch, 因此当服务器返回的 code 非 0 时, 封装好的 OkHttpClientInterceptor 将把 data 字段变为 null(发生错误时, data 字段没有实际有效的数据).

因此只需要判断 code 是否是 0 即可知道 API 是否成功执行, 不需要异常捕获.

(B站所有 API 无论是否执行成功, HttpStatus 都是 200, 判断 HTTP 状态码是无用的, 必须通过 JSON 中的 code 字段来知道 API 是否执行成功).

# 测试
测试前需要先设置用户名和密码, 在 src/test/resources 目录下, 找到 config-template.json, 将其复制一份到同目录下并命名为 config.json 然后填写其中的字段即可.

本项目使用 JUnit 作为单元测试框架. 命令行只需要执行

    gradle test

如果要在 IDEA 上进行测试, 需要运行 test 目录中的 RuleSuite 类(在 IDEA 中打开这个类, 点击行号上的重叠的两个向右箭头图标).

# 继续开发
如果您想加入到开发中, 欢迎提交 Merge Request.

本项目的 Http 请求全部使用 Retrofit 完成, 因此请求的地址和参数需要放在接口中统一管理, 如果您对 Retrofit 不是很熟悉, 可以看[这篇文章](http://square.github.io/retrofit/).

服务器返回值将被 Gson 转换为 Java POJO(Entity), 通过[这篇文章](https://github.com/google/gson/blob/master/UserGuide.md)来了解 Gson.

POJO 使用 IDEA 插件 [GsonFormat](https://plugins.jetbrains.com/plugin/7654-gsonformat) 自动化生成, 而非手动编写, 并且尽可能避免对自动生成的结果进行修改以免导致可能出现混淆或含义不明确的情况.

(插件必须开启 "use SerializedName" 选项从而保证字段名符合小驼峰命名法)

由于 B站 一些 JSON 是瞎鸡巴来的, 比如可能出现以下这种情况

    "list": [
        {
            "name": "value",
        },
        ...
    ] 

此时自动生成的类型将是

    List<List> lists

因此必须要为内层元素指定一个具有语义的名称, 例如 Name, 此时类型变为

    List<Name> names

API 尽可能按照 UI 位置来排序, 例如

    侧拉抽屉 -> 直播中心 -> 我的关注

这是 "直播中心" 页面的第一个可点击控件, 那么下一个 API 或 API 组就应该是第二个可点击组件 "观看历史".

和 UI 不对应的 API, 按照执行顺序排序, 例如进入直播间会按顺序访问一系列 API, 这些 API 就按照时间顺序排序.

对于不知道怎么排的 API, 瞎鸡巴排就好了.

# License
GPL V3
