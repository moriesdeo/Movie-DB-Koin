package com.test.data.model.base

import com.google.gson.annotations.SerializedName

open class BaseResponse<T> {
    @SerializedName("page")
    var page: Int? = null

    @SerializedName("results")
    var results: T? = null

    @SerializedName("total_pages")
    var total_pages: Int? = null

    @SerializedName("total_results")
    var total_results: Int? = null
}