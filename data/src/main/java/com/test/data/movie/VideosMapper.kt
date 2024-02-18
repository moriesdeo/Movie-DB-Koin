package com.test.data.movie

import com.test.core.extension.mapTo
import com.test.core.network.Mapper
import com.test.data.model.base.BaseResponse
import com.test.data.model.movie.VideosDataResponse
import com.test.domain.model.home.BaseResponseData
import com.test.domain.model.movie.VideosData

class VideosMapper(
    private val listMovieMapper: ListMovieMapper
) : Mapper<BaseResponse<List<VideosDataResponse>>, BaseResponseData<List<VideosData>>> {
    override fun to(t: BaseResponse<List<VideosDataResponse>>): BaseResponseData<List<VideosData>> {
        return BaseResponseData(
            results = t.results?.map { it.mapTo(listMovieMapper) }
        )
    }
}