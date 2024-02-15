package com.test.core.extension

import com.test.core.data.Resource

/**
 * @author mories.deo
 * @date 28-Jul-2023
 */

fun <T> Resource<T>.data(): T? {
    return when (this) {
        is Resource.Success -> this.model
        else -> null
    }
}