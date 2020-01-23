package com.hiczp.bilibili.api

import com.google.gson.JsonArray

@Suppress("NOTHING_TO_INLINE")
inline fun JsonArray.isEmpty() = size() == 0

@Suppress("NOTHING_TO_INLINE")
inline fun JsonArray.isNotEmpty() = size() != 0
