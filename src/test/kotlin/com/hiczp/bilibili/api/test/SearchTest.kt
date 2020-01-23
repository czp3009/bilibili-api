package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class SearchTest {
    @Test
    fun search() {
        runBlocking {
            bilibiliClient.appAPI.search(keyword = "鹿乃").await()
        }
    }

    @Test
    fun searchBangumi() {
        runBlocking {
            bilibiliClient.appAPI.searchBangumi(keyword = "凉宫春日").await()
        }
    }

    @Test
    fun searchUser() {
        runBlocking {
            bilibiliClient.appAPI.searchUser(keyword = "czp").await()
        }
    }

    @Test
    fun searchMovie() {
        runBlocking {
            bilibiliClient.appAPI.searchMovie(keyword = "透视人体").await()
        }
    }

    @Test
    fun searchArticle() {
        runBlocking {
            bilibiliClient.appAPI.searchArticle(keyword = "欧陆风云").await()
        }
    }
}
