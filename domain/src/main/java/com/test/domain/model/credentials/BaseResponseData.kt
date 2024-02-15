package com.test.domain.model.credentials

data class BaseResponseData<T>(
    var page: Int? = null,
    var results: T? = null,
    var total_pages: Int? = null,
    var total_results: Int? = null
)