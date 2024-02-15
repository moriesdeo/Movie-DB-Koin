package com.test.domain.repository

import com.test.core.data.Resource
import com.test.domain.model.credentials.ResultsItem
import com.test.domain.model.credentials.request.MovieRequest
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getDiscovery(movieRequest: MovieRequest): Flow<Resource<List<ResultsItem>>>
}