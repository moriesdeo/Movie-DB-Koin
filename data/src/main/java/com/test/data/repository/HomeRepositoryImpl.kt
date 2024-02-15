package com.test.data.repository

import com.test.core.data.Resource
import com.test.core.extension.buildNetwork
import com.test.core.extension.mapTo
import com.test.data.BuildConfig
import com.test.data.extensions.ValueExt.orZero
import com.test.data.home.ListGenreMovieMapper
import com.test.data.home.ListTopRatedMoviesMapper
import com.test.data.safeApiCall
import com.test.data.service.MoviesService
import com.test.domain.model.credentials.BaseResponseData
import com.test.domain.model.credentials.GenreData
import com.test.domain.model.credentials.ListMoviesData
import com.test.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val homeService: MoviesService,
    private val listGenreMapper: ListGenreMovieMapper,
    private val listTopRatedMoviesMapper: ListTopRatedMoviesMapper
) : MoviesRepository {
    override suspend fun getGenreMovie(): Flow<Resource<GenreData>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getGenreMovie(token, "en").mapTo(listGenreMapper)
            }
            emit(response)
        }.buildNetwork()
    }

    override suspend fun getTopRatedMovies(page: Int?): Flow<Resource<BaseResponseData<List<ListMoviesData>>>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getTopRatedMovie(token = token, lang = "en", page = page.orZero())
                    .mapTo(listTopRatedMoviesMapper)
            }
            emit(response)
        }.buildNetwork()
    }
}