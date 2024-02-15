package com.test.core.extension

import com.test.core.network.Mapper

fun <A, B> A.mapTo(mapper: Mapper<A, B>): B {
    return mapper.to(this)
}


