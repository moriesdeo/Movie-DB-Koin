package com.test.domain.repository

import com.test.core.data.Resource
import com.test.domain.model.credentials.BaseResponseData
import com.test.domain.model.credentials.GenreData
import com.test.domain.model.credentials.ListMoviesData
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getGenreMovie(): Flow<Resource<GenreData>>
    suspend fun getTopRatedMovies(page: Int?): Flow<Resource<BaseResponseData<List<ListMoviesData>>>>
}