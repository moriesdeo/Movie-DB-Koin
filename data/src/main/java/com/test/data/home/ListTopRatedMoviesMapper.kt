package com.test.data.home

import com.test.core.extension.mapTo
import com.test.core.network.Mapper
import com.test.data.model.ListMoviesDataResponse
import com.test.data.model.base.BaseResponse
import com.test.domain.model.credentials.BaseResponseData
import com.test.domain.model.credentials.ListMoviesData

class ListTopRatedMoviesMapper(
    private val listTopRatedMapper: ListTopRatedMovieDataMapper
) : Mapper<BaseResponse<List<ListMoviesDataResponse>>, BaseResponseData<List<ListMoviesData>>> {
    override fun to(t: BaseResponse<List<ListMoviesDataResponse>>): BaseResponseData<List<ListMoviesData>> {
        return BaseResponseData(
            page = t.page,
            total_pages = t.total_pages,
            total_results = t.total_results,
            results = t.results?.map { it.mapTo(listTopRatedMapper) }
        )
    }
}