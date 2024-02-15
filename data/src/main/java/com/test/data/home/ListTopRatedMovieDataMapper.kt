package com.test.data.home

import com.test.core.network.Mapper
import com.test.data.model.ListMoviesDataResponse
import com.test.domain.model.credentials.ListMoviesData

class ListTopRatedMovieDataMapper : Mapper<ListMoviesDataResponse?, ListMoviesData> {
    override fun to(t: ListMoviesDataResponse?): ListMoviesData {
        return ListMoviesData(
            adult = t?.adult,
            backdrop_path = t?.backdropPath,
            genre_ids = t?.genreIds,
            id = t?.id,
            video = t?.video
        )
    }
}