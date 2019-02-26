package com.hiczp.bilibili.api.test

import com.hiczp.bilibili.api.BilibiliClient
import com.hiczp.bilibili.api.main.model.ChildReply
import com.hiczp.bilibili.api.main.model.Reply
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.HashMap

class FetchReplyTest {
    @Test
    fun fetchReply() {
        runBlocking {
            noLoginBilibiliClient.mainAPI.reply(oid = 44154463).await()
        }
    }

    @Test
    fun fetchChildReply() {
        runBlocking {
            noLoginBilibiliClient.mainAPI.childReply(oid = 16622855, root = 1405602348).await()
        }
    }

    //打印一个视频下全部的评论
    @Test
    fun printAllReplies() {
        val aid = 44651998L

        val start = System.currentTimeMillis()

        val bilibiliClient = BilibiliClient()
        runBlocking {
            val rootReplies = LinkedList<Reply.Data.Reply>()
            val childReplies = HashMap<Long, Deferred<ChildReply>>()
            var next: Long? = null
            while (true) {
                val reply = bilibiliClient.mainAPI.reply(oid = aid, next = next).await()
                reply.data.replies.also {
                    rootReplies.addAll(it)
                }.asSequence().filterNot {
                    it.rcount == 0  //去除没有子评论的根评论
                }.forEach {
                    childReplies[it.rpid] = bilibiliClient.mainAPI.childReply(oid = aid, root = it.rpid, size = Int.MAX_VALUE)
                }
                //如果已经是最后一页
                if (reply.data.cursor.isEnd) break
                next = reply.data.cursor.next
            }

            //输出
            rootReplies.forEach { rootReply ->
                println(rootReply.content.message)
                val childReply = childReplies[rootReply.rpid]
                childReply?.await()?.data?.root?.replies?.forEach {
                    println("└──${it.content.message}")
                }
            }
        }

        val end = System.currentTimeMillis()

        println("Done in ${end - start} ms")
    }
}
