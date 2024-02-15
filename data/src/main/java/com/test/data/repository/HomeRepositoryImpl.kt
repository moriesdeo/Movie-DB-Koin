package com.test.data.repository

import com.test.core.data.Resource
import com.test.core.extension.buildNetwork
import com.test.core.extension.mapTo
import com.test.data.home.ListGenreMovieMapper
import com.test.data.safeApiCall
import com.test.data.service.HomeService
import com.test.domain.model.credentials.GenreData
import com.test.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val homeService: HomeService,
    private val listGenreMapper: ListGenreMovieMapper
) : HomeRepository {
    override suspend fun getGenreMovie(): Flow<Resource<GenreData>> {
        return flow {
            val token =
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkMzI2ZmZmNjU4ZjQ5MGM4ZTQ2NGE2ZmEzMjY0MmNhNyIsInN1YiI6IjVjYjA0ZTA4MGUwYTI2MjZlOWM0MGI0ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vMmRQZI1OMkzkhIyv_FGy-GfdS5iWKpCLVPuaM-Ba5Q"
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getGenreMovie(token, "en").mapTo(listGenreMapper)
            }
            emit(response)
        }.buildNetwork()
    }
}