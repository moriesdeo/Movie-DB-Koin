package com.test.core.network

interface Mapper<T, E> {

    fun to(t: T): E
}


