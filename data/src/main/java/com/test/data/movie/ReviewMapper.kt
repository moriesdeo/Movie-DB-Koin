package com.test.data.movie

import com.test.core.extension.mapTo
import com.test.core.network.Mapper
import com.test.data.model.base.BaseResponse
import com.test.data.model.movie.ReviewDataResponse
import com.test.domain.model.home.BaseResponseData
import com.test.domain.model.movie.ReviewData

class ReviewMapper(
    private val reviewsListMapper: ReviewsListMapper
) : Mapper<BaseResponse<List<ReviewDataResponse>>, BaseResponseData<List<ReviewData>>> {
    override fun to(t: BaseResponse<List<ReviewDataResponse>>): BaseResponseData<List<ReviewData>> {
        return BaseResponseData(results = t.results?.map { it.mapTo(reviewsListMapper) })
    }
}