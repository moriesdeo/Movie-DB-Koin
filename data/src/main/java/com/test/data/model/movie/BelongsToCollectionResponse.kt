package com.test.data.model.movie


import com.google.gson.annotations.SerializedName

data class BelongsToCollectionResponse(
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null
)