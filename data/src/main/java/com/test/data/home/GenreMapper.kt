package com.test.data.home

import com.test.core.network.Mapper
import com.test.data.model.GenreDataResponse
import com.test.domain.model.credentials.Genre

class GenreMapper : Mapper<GenreDataResponse, Genre?> {
    override fun to(t: GenreDataResponse): Genre {
        return Genre(t.id, t.name)
    }

}