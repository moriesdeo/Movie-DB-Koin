package com.test.domain.model.home.request

data class GeneralRequest(
    val page: Int? = null,
    val movieID: Int? = null,
    val genre: String? = null,
    val sortBy: String? = "popularity.desc"
)
