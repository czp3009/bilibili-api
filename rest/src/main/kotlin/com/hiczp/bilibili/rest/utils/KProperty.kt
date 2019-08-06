package com.hiczp.bilibili.rest.utils

import kotlin.reflect.KProperty0
import kotlin.reflect.jvm.isAccessible

fun KProperty0<*>.isLazyInitialized(): Boolean {
    isAccessible = true
    return (getDelegate() as Lazy<*>).isInitialized()
}
