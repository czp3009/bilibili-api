package com.hiczp.bilibili.rest

import com.github.salomonbrys.kotson.byString
import com.github.salomonbrys.kotson.fromJson
import com.github.salomonbrys.kotson.get
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.hiczp.bilibili.rest.service.passport.model.LoginResponse
import com.hiczp.bilibili.rest.service.passport.toCredential
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance.Lifecycle
import java.io.FileNotFoundException

@TestInstance(Lifecycle.PER_CLASS)
class BilibiliClientTest {
    private lateinit var loggedInBilibiliClient: BilibiliClient
    private val bilibiliClient = BilibiliClient()

    @BeforeAll
    fun init() {
        val json = BilibiliClientTest::class.java.getResourceAsStream("/config.json")?.let {
            JsonParser().parse(it.reader())
        } ?: throw FileNotFoundException("Rename '_config.json' to 'config.json' before Test")
        loggedInBilibiliClient = BilibiliClient(
                Gson().fromJson<LoginResponse>(json["loginResponse"]).toCredential()
        )
    }

    @Disabled
    @Test
    fun login() {
        val json = BilibiliClientTest::class.java.getResourceAsStream("/config.json")?.let {
            JsonParser().parse(it.reader())
        } ?: throw FileNotFoundException("Rename '_config.json' to 'config.json' before Test")
        val username by json.byString
        val password by json.byString
        val bilibiliClient = BilibiliClient()
        runBlocking {
            bilibiliClient.login(username, password)
            bilibiliClient.credential.value!!.println()
            bilibiliClient.revoke()
        }
    }

    @Test
    fun getOAuth2Info() {
        runBlocking {
            loggedInBilibiliClient.oauth2Info()!!.println()
        }
    }

    @AfterAll
    fun dispose() {
        loggedInBilibiliClient.close()
        bilibiliClient.close()
    }
}
