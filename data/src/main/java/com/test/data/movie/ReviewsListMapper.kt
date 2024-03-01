package com.test.data.movie

import com.test.core.network.Mapper
import com.test.data.model.movie.ReviewDataResponse
import com.test.domain.model.movie.AuthorDetails
import com.test.domain.model.movie.ReviewData

class ReviewsListMapper : Mapper<ReviewDataResponse, ReviewData> {
    override fun to(t: ReviewDataResponse): ReviewData {
        return ReviewData(
            author = t.author,
            author_details = AuthorDetails(
                username = t.authorDetails?.username,
                name = t.authorDetails?.name,
                rating = t.authorDetails?.rating
            ),
            id = t.id,
            content = t.content
        )
    }
}