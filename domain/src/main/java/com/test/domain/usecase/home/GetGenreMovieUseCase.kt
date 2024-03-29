package com.test.domain.usecase.home

import com.test.core.data.Resource
import com.test.core.network.FlowUseCase
import com.test.domain.model.home.GenreData
import com.test.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetGenreMovieUseCase(
    private val repository: MoviesRepository
) : FlowUseCase<Nothing, GenreData>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<GenreData>> {
        return repository.getGenreMovie()
    }

}