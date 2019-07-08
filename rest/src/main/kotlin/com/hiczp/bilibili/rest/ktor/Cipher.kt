package com.hiczp.bilibili.rest.ktor

import java.security.KeyFactory
import java.security.MessageDigest
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

@Suppress("SpellCheckingInspection")
private val hexTable = "0123456789abcdef".toCharArray()

//optimized md5
internal fun String.md5() = StringBuilder(32).apply {
    MessageDigest.getInstance("MD5").digest(toByteArray()).forEach {
        val value = it.toInt() and 0xFF
        append(hexTable[value ushr 4])
        append(hexTable[value and 0x0F])
    }
}.toString()

internal fun String.base64() = Base64.getDecoder().decode(this)

internal fun ByteArray.base64() = String(Base64.getEncoder().encode(this))

internal fun String.rsaEncrypt(publicKey: String) =
        X509EncodedKeySpec(publicKey.base64()).let {
            KeyFactory.getInstance("RSA").generatePublic(it)
        }.let {
            Cipher.getInstance("RSA/ECB/PKCS1Padding").apply {
                init(Cipher.ENCRYPT_MODE, it)
            }
        }.doFinal(toByteArray()).base64()
