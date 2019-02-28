package com.hiczp.bilibili.api.main

import com.hiczp.bilibili.api.main.model.*
import com.hiczp.bilibili.api.retrofit.CommonResponse
import com.hiczp.bilibili.api.retrofit.Header
import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 * 这也是总站 API
 */
@Suppress("DeferredIsResult")
interface MainAPI {
    /**
     * 获取一个视频下的评论
     * 注意, 评论是倒序排序的, 即楼层大的楼排在前面, 所以返回值中的 next 会比 prev 小
     * 返回值中的 rpid 为评论 id. parent 为父评论的 id, parent 为 0 的是顶级评论
     *
     * @param oid 就是 aid, 视频的唯一标识
     * @param pageSize 分页大小, 最大值 50
     * @param next 下一页的起始楼层(这一层不包含在返回值内), 注意, 翻页是越翻楼层越小的. 如果为 null 则从最后一楼(最新的评论)开始
     */
    @GET("/x/v2/reply/main")
    fun reply(
            @Query("mode") mode: Int = 1,
            @Query("next") next: Long? = null,
            @Query("oid") oid: Long,
            @Query("plat") plat: Int? = 2,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 1
    ): Deferred<Reply>

    /**
     * 获取一个视频下的评论的子评论
     *
     * @param minId 想要请求的子评论(复数)的第一个子评论的 id(子评论默认升序排序), 为 null 时从 0 楼开始
     * @param oid aid
     * @param root 根评论的 id
     * @param size 分页大小
     */
    @GET("/x/v2/reply/reply/cursor")
    fun childReply(
            @Query("min_id") minId: Long? = null,
            @Query("oid") oid: Long,
            @Query("plat") plat: Int? = 2,
            @Query("root") root: Long,
            @Query("size") size: Int = 20,
            @Query("sort") sort: Int = 0,
            @Query("type") type: Int = 1
    ): Deferred<ChildReply>

    /**
     * 查看 "对话列表"
     * 当一个子评论中有多组人在互相 at 时, 旁边就会有一个按钮 "查看对话", 将启动一个 dialog 展示内容
     * parentId 与 rootId 在请求子评论列表时取得
     *
     * @param dialog "查看对话" 按钮所在的评论所 at 的那条评论的 id, 即 parentId
     * @param minFloor 最小楼层, 翻页参数
     * @param oid aid
     * @param root "查看对话" 按钮所在的根评论 id, 即 rootId
     * @param size 分页大小
     *
     * @see childReply
     */
    @GET("/x/v2/reply/dialog/cursor")
    fun chatList(
            @Query("dialog") dialog: Long,
            @Query("min_floor") minFloor: Long? = null,
            @Query("oid") oid: Long,
            @Query("plat") plat: Int? = 2,
            @Query("root") root: Long,
            @Query("size") size: Int = 20,
            @Query("type") type: Int = 1
    ): Deferred<ChatList>

    /**
     * 获得一个番剧的分季信息(生成番剧页面所需的信息), 包含当前选择的季的分集信息
     * seasonId 或 episodeId 必须有一个, 如果用 episodeId 将跳转到对应的 season 的页面
     * 返回值中, 每个 episode 都有 aid 和 cid
     *
     * @param seasonId 季的唯一标识
     * @param episodeId 集的唯一标识
     */
    @GET("/pgc/view/app/season")
    fun season(
            @Query("season_id") seasonId: Long? = null,
            @Query("ep_id") episodeId: Long? = null,
            @Query("track_path") trackPath: Int? = null
    ): Deferred<Season>

    /**
     * 番剧页面下方的推荐(对当前季进行推荐)
     * 返回值中的 relates 是 "相关推荐"(广告), season 是 "更多推荐"(其他番, 目标为季)
     *
     * @param seasonId 季的唯一标识
     */
    @GET("/pgc/season/app/related/recommend")
    fun recommend(@Query("season_id") seasonId: Long): Deferred<Recommend>

    /**
     * 我的追番动态(追番页面上方的那一条 "我的追番")
     * 首页 -> 追番 -> 我的追番
     */
    @Suppress("SpellCheckingInspection")
    @GET("/pgc/app/page/bangumi/mine")
    fun myBangumiNews(
            @Query("fnval") fnval: Int = 16,
            @Query("fnver") fnver: Int = 0
    ): Deferred<MyBangumiNews>

    /**
     * 追番页面(客户端用这里面的数据来生成追番页面)
     * 每个模块(module)的数据(item)全部超过三个.
     * 每个板块下面的 换一换 按钮并不重新请求数据, 而是从每个模块的数据里选出另一批
     * 首页 -> 追番
     *
     * @param pgcHomeTimelineABTest 与 A/B Test 有关, 不明确其值含义, 有可能使得返回内容不一样
     */
    @Suppress("SpellCheckingInspection")
    @GET("/pgc/app/page/bangumi")
    fun bangumiPage(
            @Query("fnval") fnval: Int = 16,
            @Query("fnver") fnver: Int = 0,
            @Query("pgc_home_timeline_abtest") pgcHomeTimelineABTest: Int? = 13
    ): Deferred<BangumiPage>

    /**
     * 获得更多 "编辑推荐"
     * 首页 -> 追番 -> (下拉)
     *
     * @param cursor 表示时间(ms), 但是可能是科学计数法. 每次请求所用的 cursor 在上一次的返回值里的最后一个 item 里. 第一次请求所用的 cursor 在追番页面的返回值的最后.
     * @param size 分页大小
     * @param wid 不明确, 有可能是一些 padding, margin, 用于计算位置
     *
     * @see bangumiPage
     */
    fun bangumiMore(
            @Query("cursor") cursor: String,
            @Query("size") size: Int = 10,
            @Query("wid") wid: String? = "78,79,80,81,59"
    ): Deferred<BangumiMore>

    /**
     * 发送评论
     * 如果发送根评论则 root 和 parent 为 null
     * 如果发送子评论则 root 和 parent 均为根评论的 id
     * 如果在子评论中 at 别人(即对子评论进行评论), 那么 root 为所属根评论的 id, parent 为所 at 的那个评论的 id
     * at 别人时, 评论的内容必须符合以下格式 "回复 @$username :$message"
     *
     * @param message 发送的内容
     * @param oid aid
     * @param parent 父评论 id
     * @param root 根评论 id
     */
    @POST("/x/v2/reply/add")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun sendReply(
            @Field("from") from: Int? = null,
            @Field("message") message: String,
            @Field("oid") oid: Long,
            @Field("parent") parent: Long? = null,
            @Field("plat") plat: Int = 2,
            @Field("root") root: Long? = null,
            @Field("type") type: Int = 1
    ): Deferred<SendReplyResponse>

    /**
     * 点赞(评论)
     *
     * @param action 为 1 时表示点赞, 0 表示取消点赞
     * @param oid aid
     * @param replyId 评论的 ID
     */
    @Suppress("SpellCheckingInspection")
    @POST("/x/v2/reply/action")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun likeReply(
            @Field("action") action: Int,
            @Field("oid") oid: Long,
            @Field("rpid") replyId: Long,
            @Field("type") type: Int = 1
    ): Deferred<CommonResponse>

    /**
     * 不喜欢(评论)
     *
     * @param action 为 1 时表示不喜欢, 为 0 时表示取消不喜欢
     * @param oid aid
     * @param replyId 评论的 ID
     */
    @Suppress("SpellCheckingInspection")
    @POST("/x/v2/reply/hate")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun dislikeReply(
            @Field("action") action: Int,
            @Field("oid") oid: Long,
            @Field("rpid") replyId: Long,
            @Field("type") type: Int = 1
    ): Deferred<CommonResponse>

    /**
     * 查看视频的删除日志
     * 这个 API 看起来有翻页, 其实没有页
     * 视频 -> 评论 -> 右上角三个点 ->查看删除日志
     *
     * @return 有$replyCount条评论因$reportCount次举报已被管理员移除
     */
    @GET("/x/v2/reply/log")
    fun deleteLog(
            @Query("oid") oid: Long,
            @Query("pn") pageNumber: Int = 1,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 1
    ): Deferred<DeleteLog>

    /**
     * 改变与某用户的关系(关注, 取消关注)
     *
     * @param action 动作类型(1: 关注;2: 取消关注)
     * @param followId 操作对象的 ID(例如欲关注的那个用户的 ID)
     * @param reSrc 不明确
     */
    @POST("/x/relation/modify")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun modifyRelation(
            @Field("act") action: Int,
            @Field("fid") followId: Long,
            @Field("re_src") reSrc: Int? = 32
    ): Deferred<CommonResponse>

    /**
     * 查看关注分组
     * 默认分组永远是 0
     */
    @GET("/x/relation/tag/m/tags")
    fun relationTags(): Deferred<RelationTags>

    /**
     * 创建关注分组
     *
     * @param tag 不能包含绝大部分符号
     */
    @POST("/x/relation/tag/create")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun createRelationTag(@Field("tag") tag: String): Deferred<CreateRelationTagResponse>

    /**
     * 设置分组(对某个用户的关注的分组)
     * 用户 -> 关注 -> 设置分组
     *
     * @param followIds 关注的人(不明确能不能有多个)
     * @param tagIds 分组 id. 可以有多个, 用逗号隔开, 例如 "-10,110641"
     */
    @Suppress("SpellCheckingInspection")
    @POST("/x/relation/tags/addUsers")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun relationAddUsers(
            @Field("fids") followIds: String,
            @Field("tagids") tagIds: String
    ): Deferred<CommonResponse>

    /**
     * 收藏文章
     *
     * @param id 文章的 id
     */
    @POST("/x/article/favorites/add")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun addFavoriteArticle(@Field("id") id: Long): Deferred<CommonResponse>

    /**
     * 点赞(文章)
     *
     * @param id 文章的 id
     * @param type 操作类型, 1 为点赞, 2 为取消点赞
     */
    @POST("/x/article/like")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun articleLike(@Field("id") id: Long, @Field("type") type: Int): Deferred<CommonResponse>

    /**
     * 查看收藏夹分组
     *
     * @param aid 视频的唯一标识, 用于判断是否已经将当前视频加入收藏夹
     * @param vmId 用户 id
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/fav/folder")
    fun favoriteFolder(
            @Query("aid") aid: Long,
            @Query("vmid") vmId: Long
    ): Deferred<FavoriteFolder>

    /**
     * 创建收藏夹
     *
     * @param name 收藏夹名
     * @param public 是否公开, 0 为公开
     */
    @POST("/x/v2/fav/folder/add")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun createFavoriteFolder(
            @Field("name") name: String,
            @Field("public") public: Int = 0
    ): Deferred<CreateFavoriteFolderResponse>

    /**
     * 收藏视频
     *
     * @param fid 收藏夹的 id, 可以有多个, 用逗号隔开. 例如 795158,3326376
     */
    @POST("/x/v2/fav/video/add")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun addFavoriteVideo(
            @Field("aid") aid: Long,
            @Field("fid") fid: String,
            @Field("from") from: Int? = null
    ): Deferred<CommonResponse>

    /**
     * 取消收藏视频
     *
     * @param fid 收藏夹的 id, 可以有多个, 同上
     *
     * @see addFavoriteVideo
     */
    @POST("/x/v2/fav/video/del")
    @FormUrlEncoded
    @Headers(Header.FORCE_FORM_BODY)
    fun deleteFavoriteVideo(
            @Field("aid") aid: Long,
            @Field("fid") fid: String
    ): Deferred<CommonResponse>
}
