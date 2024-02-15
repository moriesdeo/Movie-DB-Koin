package com.test.data.model


import com.google.gson.annotations.SerializedName

data class GenreDataResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null
)