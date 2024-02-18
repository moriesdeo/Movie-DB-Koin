package com.test.data.movie

import com.test.core.network.Mapper
import com.test.data.model.movie.DetailMovieDataResponse
import com.test.domain.model.movie.DetailMovieData

class DetailMovieMapper : Mapper<DetailMovieDataResponse, DetailMovieData> {
    override fun to(t: DetailMovieDataResponse): DetailMovieData {
        return DetailMovieData(
            poster_path = t.posterPath,
            id = t.id,
            video = t.video,
            backdrop_path = t.backdropPath,
            release_date = t.releaseDate,
            popularity = t.popularity
        )
    }
}