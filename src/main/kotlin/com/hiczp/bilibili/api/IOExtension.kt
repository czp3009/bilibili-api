package com.hiczp.bilibili.api

import com.hiczp.bilibili.api.thirdpart.commons.BoundedInputStream
import io.ktor.util.InternalAPI
import io.ktor.utils.io.errors.EOFException
import java.io.InputStream

//减少包引入
//https://github.com/apache/commons-io/blob/master/src/main/java/org/apache/commons/io/IOUtils.java
fun InputStream.readFully(length: Int): ByteArray {
    if (length < 0) {
        throw  IllegalArgumentException("Length must not be negative: $length")
    }

    val byteArray = ByteArray(length)
    var remaining = length

    while (remaining > 0) {
        val count = read(byteArray, length - remaining, remaining)
        if (count == -1) break
        remaining -= count
    }

    val actual = length - remaining
    if (actual != length) {
        throw  EOFException("Length to read: $length actual: $actual")
    }

    return byteArray
}

/**
 * 以大端模式从流中读取一个 int
 */
@OptIn(ExperimentalUnsignedTypes::class)
fun InputStream.readInt(): Int {
    val byteArray = readFully(4)
    return (byteArray[0].toUByte().toInt() shl 24) or
            (byteArray[1].toUByte().toInt() shl 16) or
            (byteArray[2].toUByte().toInt() shl 8) or
            (byteArray[3].toUByte().toInt())
}

/**
 * 以大端模式从流中读取一个 unsigned int
 */
@OptIn(ExperimentalUnsignedTypes::class)
fun InputStream.readUInt() = readInt().toUInt()

fun InputStream.bounded(size: Long) = BoundedInputStream(this, size)

@OptIn(ExperimentalUnsignedTypes::class)
fun InputStream.bounded(size: UInt) = bounded(size.toLong())

@OptIn(InternalAPI::class)
internal fun ByteArray.toPrettyPrintString() = joinToString(prefix = "[", postfix = "]") { "0x%02x".format(it) }
