package com.hiczp.bilibili.api.test

import kotlin.system.measureTimeMillis

/**
 * 输出执行时间
 */
inline fun printTimeMillis(block: () -> Unit) {
    val time = measureTimeMillis(block)
    println("Done in $time ms")
}
