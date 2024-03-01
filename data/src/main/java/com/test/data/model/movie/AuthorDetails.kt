package com.test.data.model.movie


import com.google.gson.annotations.SerializedName

data class AuthorDetails(
    @SerializedName("avatar_path")
    val avatarPath: Any? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("rating")
    val rating: Int? = null,
    @SerializedName("username")
    val username: String? = null
)