package com.test.data.repository

import com.test.core.data.Resource
import com.test.core.extension.buildNetwork
import com.test.core.extension.mapTo
import com.test.data.BuildConfig
import com.test.data.extensions.ValueExt.orZero
import com.test.data.home.ListGenreMovieMapper
import com.test.data.home.ListTopRatedMoviesMapper
import com.test.data.movie.DetailMovieMapper
import com.test.data.movie.ReviewMapper
import com.test.data.movie.VideosMapper
import com.test.data.safeApiCall
import com.test.data.service.MoviesService
import com.test.domain.model.home.BaseResponseData
import com.test.domain.model.home.GenreData
import com.test.domain.model.home.request.GeneralRequest
import com.test.domain.model.movie.DetailMovieData
import com.test.domain.model.movie.ListMoviesData
import com.test.domain.model.movie.ReviewData
import com.test.domain.model.movie.VideosData
import com.test.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val homeService: MoviesService,
    private val listGenreMapper: ListGenreMovieMapper,
    private val listTopRatedMoviesMapper: ListTopRatedMoviesMapper,
    private val detailMovieMapper: DetailMovieMapper,
    private val videosMapper: VideosMapper,
    private val reviewMapper: ReviewMapper
) : MoviesRepository {
    override suspend fun getGenreMovie(): Flow<Resource<GenreData>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getGenreMovie(token, "en").mapTo(listGenreMapper)
            }
            emit(response)
        }.buildNetwork()
    }

    override suspend fun getTopRatedMovies(page: Int?): Flow<Resource<BaseResponseData<List<ListMoviesData>>>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getTopRatedMovie(token = token, lang = "en", page = page.orZero())
                    .mapTo(listTopRatedMoviesMapper)
            }
            emit(response)
        }.buildNetwork()
    }

    override suspend fun getDiscoverMovie(generalRequest: GeneralRequest?): Flow<Resource<BaseResponseData<List<ListMoviesData>>>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getMovie(
                    token = token,
                    lang = "en",
                    includeAdult = false,
                    includeVideo = false,
                    withGenres = generalRequest?.genre.orEmpty(),
                    sortBy = generalRequest?.sortBy.orEmpty(),
                    page = generalRequest?.page.orZero()
                ).mapTo(listTopRatedMoviesMapper)
            }
            emit(response)
        }.buildNetwork()
    }

    override suspend fun getDetailMovie(generalRequest: GeneralRequest?): Flow<Resource<DetailMovieData>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getDetailMovie(
                    token = token, lang = "en", movieID = generalRequest?.movieID.orZero()
                ).mapTo(detailMovieMapper)
            }
            emit(response)
        }.buildNetwork()
    }

    override suspend fun getVideo(generalRequest: GeneralRequest?): Flow<Resource<BaseResponseData<List<VideosData>>>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getVideos(
                    token = token, lang = "en",
                    movieID = generalRequest?.movieID.orZero()
                ).mapTo(videosMapper)
            }
            emit(response)
        }.buildNetwork()
    }

    override suspend fun getReviews(generalRequest: GeneralRequest?): Flow<Resource<BaseResponseData<List<ReviewData>>>> {
        return flow {
            val token = BuildConfig.TOKEN
            val response = safeApiCall(Dispatchers.IO) {
                homeService.getReviews(
                    token = token, lang = "en",
                    movieID = generalRequest?.movieID.orZero()
                ).mapTo(reviewMapper)
            }
            emit(response)
        }.buildNetwork()
    }
}