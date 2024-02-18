package com.test.data.home

import com.test.core.network.Mapper
import com.test.data.model.ListMoviesDataResponse
import com.test.domain.model.movie.ListMoviesData

class ListTopRatedMovieDataMapper : Mapper<ListMoviesDataResponse?, ListMoviesData> {
    override fun to(t: ListMoviesDataResponse?): ListMoviesData {
        return ListMoviesData(
            adult = t?.adult,
            backdrop_path = t?.backdropPath,
            poster_path = t?.posterPath,
            genre_ids = t?.genreIds,
            id = t?.id,
            video = t?.video,
            title = t?.title,
            release_date = t?.releaseDate
        )
    }
}