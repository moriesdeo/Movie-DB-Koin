package com.test.domain.repository

import com.test.core.data.Resource
import com.test.domain.model.credentials.GenreData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getGenreMovie(): Flow<Resource<GenreData>>
}