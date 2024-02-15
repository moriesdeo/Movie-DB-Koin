package com.test.core.extension

fun <T> T.use(listener: T.() -> Unit) = listener.invoke(this)