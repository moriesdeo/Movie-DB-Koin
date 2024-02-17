package com.test.domain.usecase.movie

import com.test.core.data.Resource
import com.test.core.network.FlowUseCase
import com.test.domain.model.credentials.BaseResponseData
import com.test.domain.model.credentials.ListMoviesData
import com.test.domain.model.credentials.request.GeneralRequest
import com.test.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMovieUseCase(
    private val repository: MoviesRepository
) : FlowUseCase<GeneralRequest, BaseResponseData<List<ListMoviesData>>>() {
    override suspend fun execute(parameters: GeneralRequest?): Flow<Resource<BaseResponseData<List<ListMoviesData>>>> {
        return repository.getDiscoverMovie(parameters)
    }
}