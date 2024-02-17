package com.test.data.service

import com.test.data.model.GenreResponse
import com.test.data.model.ListMoviesDataResponse
import com.test.data.model.base.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesService {
    @GET("genre/movie/list")
    @Headers("Content-Type:application/json")
    suspend fun getGenreMovie(
        @Header("Authorization") token: String,
        @Query("language") lang: String
    ): GenreResponse

    @GET("movie/top_rated")
    @Headers("Content-Type:application/json")
    suspend fun getTopRatedMovie(
        @Header("Authorization") token: String,
        @Query("language") lang: String,
        @Query("page") page: Int,
    ): BaseResponse<List<ListMoviesDataResponse>>

    @GET("discover/movie")
    @Headers("Content-Type:application/json")
    suspend fun getMovie(
        @Header("Authorization") token: String,
        @Query("language") lang: String,
        @Query("include_adult") includeAdult: Boolean,
        @Query("include_video") includeVideo: Boolean,
        @Query("sort_by") sortBy: String,
        @Query("with_genres") withGenres: String,
        @Query("page") page: Int,
    ): BaseResponse<List<ListMoviesDataResponse>>
}