package com.hiczp.bilibili.api.utils

import java.security.KeyFactory
import java.security.MessageDigest
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

@Suppress("SpellCheckingInspection")
private val hexTable = "0123456789abcdef".toCharArray()

internal fun String.toMD5() = buildString(32) {
    MessageDigest.getInstance("MD5").digest(toByteArray()).forEach {
        val value = it.toInt() and 0xFF
        append(hexTable[value ushr 4])
        append(hexTable[value and 0x0F])
    }
}

internal fun String.base64Decode() = Base64.getDecoder().decode(this)

internal fun ByteArray.base64Encode() = Base64.getEncoder().encodeToString(this)

internal typealias PEM = String

internal typealias DER = ByteArray

internal fun String.rsaEncrypt(publicKey: DER) =
    X509EncodedKeySpec(publicKey).let {
        KeyFactory.getInstance("RSA").generatePublic(it)
    }.let {
        Cipher.getInstance("RSA/ECB/PKCS1Padding").apply {
            init(Cipher.ENCRYPT_MODE, it)
        }
    }.doFinal(toByteArray()).base64Encode()

internal fun PEM.toDER(): DER = split('\n').filterNot { it.startsWith('-') }.joinToString(separator = "").base64Decode()
