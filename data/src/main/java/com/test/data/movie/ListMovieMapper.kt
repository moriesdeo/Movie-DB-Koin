package com.test.data.movie

import com.test.core.network.Mapper
import com.test.data.model.movie.VideosDataResponse
import com.test.domain.model.movie.VideosData

class ListMovieMapper : Mapper<VideosDataResponse, VideosData> {
    override fun to(t: VideosDataResponse): VideosData {
        return VideosData(
            key = t.key
        )
    }
}