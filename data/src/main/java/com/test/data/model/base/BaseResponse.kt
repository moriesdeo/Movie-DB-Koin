package com.test.data.model.base

import com.google.gson.annotations.SerializedName

open class BaseResponse<T> {
    @SerializedName("message")
    var message: String? = null

    @SerializedName("data")
    var data: T? = null
}