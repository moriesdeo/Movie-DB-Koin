package com.test.domain.repository

import com.test.core.data.Resource
import com.test.domain.model.home.BaseResponseData
import com.test.domain.model.home.GenreData
import com.test.domain.model.home.request.GeneralRequest
import com.test.domain.model.movie.DetailMovieData
import com.test.domain.model.movie.ListMoviesData
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getGenreMovie(): Flow<Resource<GenreData>>
    suspend fun getTopRatedMovies(page: Int?): Flow<Resource<BaseResponseData<List<ListMoviesData>>>>
    suspend fun getDiscoverMovie(generalRequest: GeneralRequest?): Flow<Resource<BaseResponseData<List<ListMoviesData>>>>
    suspend fun getDetailMovie(generalRequest: GeneralRequest?): Flow<Resource<DetailMovieData>>
}