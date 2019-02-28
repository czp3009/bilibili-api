package com.hiczp.bilibili.api.test

/**
 * 土制切面
 */
inline fun timer(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("Done in ${end - start} ms")
}
