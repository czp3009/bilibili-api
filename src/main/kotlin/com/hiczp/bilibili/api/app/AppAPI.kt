package com.hiczp.bilibili.api.app

import com.google.gson.JsonObject
import com.hiczp.bilibili.api.app.model.*
import com.hiczp.bilibili.api.retrofit.CommonResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*
import java.time.Instant

/**
 * 总站 API
 */
@Suppress("DeferredIsResult")
interface AppAPI {
    /**
     * 打开 APP 时将访问此接口来获得 UI 排布顺序
     * 包括下方 tab(首页, 频道, 动态, 会员购), 首页的上方 tab(直播, 推荐, 热门, 追番) 以及右上角的 游戏中心, 离线下载, 消息
     */
    @GET("/x/resource/show/tab")
    fun tab(): Deferred<Tab>

    /**
     * 登陆完成后将请求一次此接口以获得个人资料
     * 如果未登录将返回 {"code":-101,"message":"账号未登录","ttl":1}
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/account/myinfo")
    fun myInfo(): Deferred<MyInfo>

    /**
     * 登陆后也会访问此接口, 返回内容大致与 myInfo() 相同
     */
    @GET("/x/v2/account/mine")
    fun mine(): Deferred<Mine>

    /**
     * 侧边栏中动态增加的按钮, 返回信息包含 URI 地址(到对应的 activity)
     * 侧拉抽屉
     */
    @GET("/x/resource/sidebar")
    fun sidebar(): Deferred<Sidebar>

    /**
     * 首页内容(客户端通过解析返回的内容来生成页面内容, 下同)
     * 该 API 没有翻页参数, 同样的参数每次请求都会返回不一样的内容. 刷新和下拉只是简单的重新访问此接口.
     * 首页 -> 推荐
     *
     * @param pull 如果是通过滑动到最顶端来刷新页面的, 那么将是 true, 将页面滑动到最底端来获取更多内容将是 false
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/feed/index")
    fun homePage(
            @Query("ad_extra") adExtra: String? = null,
            @Query("autoplay_card") autoplayCard: Int = 0,
            @Query("banner_hash") bannerHash: String? = null,
            @Query("column") column: Int = 2,
            @Query("device_type") deviceType: Int = 0,
            @Query("flush") flush: Int = 0,
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("force_host") forceHost: Int = 0,
            @Query("idx") index: Long = Instant.now().epochSecond,
            @Query("login_event") loginEvent: Int = 0,
            @Query("network") network: String = "mobile",
            @Query("open_event") openEvent: String? = null,
            @Query("pull") pull: Boolean = true,
            @Query("qn") qn: Int = 32,
            @Query("recsys_mode") recsysMode: Int = 0
    ): Deferred<HomePage>

    /**
     * 热门页面
     * 首页 -> 热门
     *
     * @param index 翻页参数, 一开始为 0, 然后每次滑动到底端就会加 10
     * @param ver 第一次请求时没有这个参数, 第二次开始这个参数为上一次请求此接口时的返回值中的 `ver`
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/show/popular/index")
    fun popularPage(
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("force_host") forceHost: Int = 0,
            @Query("idx") index: Long = 0,
            @Query("last_param") lastParam: String? = null,
            @Query("login_event") loginEvent: Int = 0,
            @Query("qn") qn: Int = 32,
            @Query("ver") ver: Long? = null
    ): Deferred<PopularPage>

    /**
     * 视频页面(普通视频, 非番剧)
     * 包含视频基本信息, 推荐和广告
     * 从这个接口得到视频的 cid
     * 如果返回内容里的 pages 有多个表明有多个 p, 每个 p 有自己的 cid(外层的 cid 为默认的那个 p 的 cid)
     *
     * @param aid 视频的唯一标识
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/view")
    fun view(
            @Query("ad_extra") adExtra: String? = null,
            @Query("aid") aid: Long,
            @Query("autoplay") autoplay: Int = 0,
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("force_host") forceHost: Int = 0,
            @Query("from") from: Int? = null,
            @Query("plat") plat: Int = 0,
            @Query("qn") qn: Int = 32,
            @Query("trackid") trackId: String? = null //all_10.shylf-ai-recsys-120.1550674524909.237
    ): Deferred<View>

    /**
     * 点赞(视频)
     *
     * @param aid 视频的唯一标识
     * @param like 为 0 时表示点赞, 为 1 时表示取消点赞
     * @param dislike 正常为 0, 为 1 时(like 为 0)表示 取消不喜欢的同时为该视频点赞(等于做了两个操作, 下同)
     */
    @POST("/x/v2/view/like")
    @FormUrlEncoded
    fun like(
            @Field("aid") aid: Long,
            @Field("like") like: Int = 0,
            @Field("dislike") dislike: Int = 0,
            @Field("from") from: Int? = null
    ): Deferred<LikeResponse>

    /**
     * 不喜欢(视频)
     *
     * @param aid 视频的唯一标识
     * @param dislike 为 0 时表示不喜欢, 为 1 时表示取消不喜欢
     * @param like 正常为 0, 为 1 时(dislike 为 0)表示 取消点赞的同时不喜欢该视频
     */
    @POST("/x/v2/view/dislike")
    @FormUrlEncoded
    fun dislike(
            @Field("aid") aid: Long,
            @Field("like") like: Int = 0,
            @Field("dislike") dislike: Int = 0,
            @Field("from") from: Int? = null
    ): Deferred<CommonResponse>

    /**
     * 投币
     * 自制视频能投两个, 转载视频只能投一个. 是转载还是自制在获取视频页面的 API 的 copyright.
     *
     * @param multiply 投币数量
     * @param selectLike 为 1 表示投币的同时为视频点赞, 对番剧投币时, 该值总为 0
     * @param upId 该值似乎总为 0
     *
     * @see view
     */
    @Suppress("SpellCheckingInspection")
    @POST("/x/v2/view/coin/add")
    @FormUrlEncoded
    fun addCoin(
            @Field("aid") aid: Long,
            @Field("avtype") avType: Int = 1,
            @Field("from") from: Int? = null,
            @Field("multiply") multiply: Int,
            @Field("select_like") selectLike: Int = 0,
            @Field("upid") upId: Long? = 0
    ): Deferred<AddCoinResponse>

    /**
     * 查看某个用户的主页(也可以查看自己)
     *
     * @param vmId 欲查看的用户的 id
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/space")
    fun space(
            @Query("from") from: Int? = 0,
            @Query("ps") pageSize: Int = 10,
            @Query("vmid") vmId: Long
    ): Deferred<Space>

    /**
     * 收藏页面
     * 侧拉抽屉 -> 收藏
     *
     * @param vmId 所查看的用户的 id(看自己的收藏也要有该参数)
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/favorite")
    fun favoritePage(
            @Query("aid") aid: Long = 0,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("vmid") vmId: Long
    ): Deferred<FavoritePage>

    /**
     * 收藏的视频
     * 侧拉抽屉 -> 收藏 -> 视频 -> (打开一个收藏夹)
     *
     * @param fid 收藏夹的 id, 在拉取收藏页面时获得
     * @param tid 不明确
     * @param vmId 用户 id
     *
     * @see favoritePage
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/favorite/video")
    fun favoriteVideo(
            @Query("fid") fid: Long,
            @Query("order") order: String = "ftime",
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("tid") tid: Long = 0,
            @Query("vmid") vmId: Long
    ): Deferred<FavoriteVideo>

    /**
     * 收藏的文章
     * 这个 API 的返回内容里没有总页数, 真实的客户端会直接访问下一页来确认当前页是不是最后一页
     * 侧拉抽屉 -> 收藏 -> 专栏
     */
    @GET("/x/v2/favorite/article")
    fun favoriteArticle(
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20
    ): Deferred<FavoriteArticle>

    /**
     * 大家都在搜(热搜关键字列表)
     *
     * 上方搜索栏 -> 搜索提示
     *
     * @param limit 分页大小
     */
    @GET("/x/v2/search/hot")
    fun searchHot(@Query("limit") limit: Int = 50): Deferred<SearchHot>

    /**
     * 默认搜索词, 当点击搜索框但是没输入内容时就会显示该词条.
     *
     * 上方搜索框 -> placeholder
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/search/defaultwords")
    fun searchDefaultWords(): Deferred<SearchDefaultWords>

    /**
     * 搜索联想
     *
     * 上方搜索框 -> 搜索时的显示的候选项
     */
    @GET("/x/v2/search/suggest3")
    fun searchSuggest(
            @Query("highlight") highlight: Int = 1,
            @Query("keyword") keyword: String
    ): Deferred<SearchSuggest>

    /**
     * 搜索(综合)
     *
     * 上方搜索栏
     *
     * @param order 排序. null/default 默认排序, view 播放多, pubdate 新发布, danmaku 弹幕多
     * @param duration 视频时长. 0 全部时长, 1 0-10分钟, 2 10-30分钟, 3 30-60分钟, 4 60+分钟
     * @param rid 按某种分区搜索, 编号为数字. null 全部分区.
     * @param keyword 搜索的关键字, 下同
     * @param from_source 来源, 如果是直接搜索的则为 app_search, 在历史记录里点击的则为 apphistory_search, 从搜索时的候选项里点的为 appsuggest_search
     * @param pageNumber 分页, 从 1 开始
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/search")
    fun search(
            @Query("duration") duration: Int = 0,
            @Query("from_source") from_source: String = "app_search",
            @Query("highlight") highlight: Int = 1,
            @Query("keyword") keyword: String,
            @Query("order") order: String? = null,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("recommend") recommend: Int = 1,
            @Query("rid") rid: Int? = null
    ): Deferred<SearchResult>

    /**
     * 搜索直播间
     *
     * 上方搜索栏 -> 直播
     *
     * @param type 搜索的内容的类型, 每种搜索的 type 都是固定的, 下同
     */
    @GET("/x/v2/search/live")
    fun searchLive(
            @Query("keyword") keyword: String,
            @Suppress("SpellCheckingInspection")
            @Query("order") order: String = "totalrank",
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 4
    ): Deferred<SearchLiveResult>

    /**
     * 根据某个类型来进行搜索(自定义)
     */
    @GET("/x/v2/search/type")
    fun searchType(
            @Query("keyword") keyword: String,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int,
            @QueryMap additionParam: Map<String, String>
    ): Deferred<JsonObject>

    /**
     * 搜索番剧
     *
     * 上方搜索栏 -> 番剧
     */
    @GET("/x/v2/search/type")
    fun searchBangumi(
            @Query("keyword") keyword: String,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 7
    ): Deferred<SearchBangumiResult>

    /**
     * 搜索用户
     *
     * 上方搜索栏 -> 用户
     *
     * @param order 排序维度. totalrank 默认排序,fans 粉丝, level 等级.
     * @param orderSort 排序顺序. 0 从高到低, 1 从低到高.
     * @param userType 用户类型. 0 全部用户, 1 up主, 2 普通用户, 3 认证用户.
     *
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/search/type")
    fun searchUser(
            @Query("highlight") highlight: Int = 1,
            @Query("keyword") keyword: String,
            @Query("order") order: String = "totalrank",
            @Query("order_sort") orderSort: Int? = null,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 2,
            @Query("user_type") userType: Int = 0
    ): Deferred<SearchUserResult>

    /**
     * 搜索影视(包括动漫的剧场版和纪录片)
     *
     * 上方搜索栏 -> 影视
     */
    @GET("/x/v2/search/type")
    fun searchMovie(
            @Query("keyword") keyword: String,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 8
    ): Deferred<SearchMovieResult>

    /**
     * 搜索文章
     *
     * 上方搜索栏 -> 专栏
     *
     * @param order 排序. null 默认排序, pubdate 发布时间, click 按阅读数, scores 按评论数, attention 按点赞数.
     * @param categoryId 分类, 编号为数字. 0 全部分类.
     *
     * @see com.hiczp.bilibili.api.main.MainAPI.articleCategories
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/search/type")
    fun searchArticle(
            @Query("category_id") categoryId: Int = 0,
            @Query("highlight") highlight: Int = 1,
            @Query("keyword") keyword: String,
            @Query("order") order: String? = null,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 6
    ): Deferred<SearchArticleResult>
}
