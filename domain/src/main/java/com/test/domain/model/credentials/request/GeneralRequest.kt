package com.test.domain.model.credentials.request

data class GeneralRequest(
    val page: Int? = null,
    val genre: String? = null,
    val sortBy: String? = "popularity.desc"
)
