package com.test.data.home

import com.test.core.extension.mapTo
import com.test.core.network.Mapper
import com.test.data.model.GenreResponse
import com.test.domain.model.credentials.GenreData

class ListGenreMovieMapper(private val genreMapper: GenreMapper) :
    Mapper<GenreResponse, GenreData?> {
    override fun to(t: GenreResponse): GenreData {
        return GenreData(
            genres = t.genres?.map { it.mapTo(genreMapper) }
        )
    }

}