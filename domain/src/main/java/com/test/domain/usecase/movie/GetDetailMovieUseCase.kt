package com.test.domain.usecase.movie

import com.test.core.data.Resource
import com.test.core.network.FlowUseCase
import com.test.domain.model.home.request.GeneralRequest
import com.test.domain.model.movie.DetailMovieData
import com.test.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetDetailMovieUseCase(
    private val repository: MoviesRepository
) : FlowUseCase<GeneralRequest, DetailMovieData>() {
    override suspend fun execute(parameters: GeneralRequest?): Flow<Resource<DetailMovieData>> {
        return repository.getDetailMovie(parameters)
    }
}