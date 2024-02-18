package com.test.domain.usecase.movie

import com.test.core.data.Resource
import com.test.core.network.FlowUseCase
import com.test.domain.model.home.BaseResponseData
import com.test.domain.model.home.request.GeneralRequest
import com.test.domain.model.movie.VideosData
import com.test.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetVideosUseCase(
    private val repository: MoviesRepository
) : FlowUseCase<GeneralRequest, BaseResponseData<List<VideosData>>>() {
    override suspend fun execute(parameters: GeneralRequest?): Flow<Resource<BaseResponseData<List<VideosData>>>> {
        return repository.getVideo(parameters)
    }
}