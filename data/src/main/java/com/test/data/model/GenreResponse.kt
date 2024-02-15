package com.test.data.model


import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres")
    var genres: List<GenreDataResponse>? = listOf()
)