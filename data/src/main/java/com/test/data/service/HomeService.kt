package com.test.data.service

import com.test.data.model.GenreResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface HomeService {
    @GET("genre/movie/list")
    @Headers("Content-Type:application/json")
    suspend fun getGenreMovie(
        @Header("Authorization") token: String,
        @Query("language") lang: String
    ): GenreResponse
}