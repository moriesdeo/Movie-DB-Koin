package com.test.moviedbkoin.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.core.data.Resource
import com.test.domain.model.home.BaseResponseData
import com.test.domain.model.home.GenreData
import com.test.domain.model.home.request.GeneralRequest
import com.test.domain.model.movie.DetailMovieData
import com.test.domain.model.movie.ListMoviesData
import com.test.domain.model.movie.ReviewData
import com.test.domain.model.movie.VideosData
import com.test.domain.usecase.home.GetGenreMovieUseCase
import com.test.domain.usecase.movie.GetDetailMovieUseCase
import com.test.domain.usecase.movie.GetMovieUseCase
import com.test.domain.usecase.movie.GetReviewsUseCase
import com.test.domain.usecase.movie.GetTopRatedMovieUseCase
import com.test.domain.usecase.movie.GetVideosUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val genreMovieUseCase: GetGenreMovieUseCase,
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase,
    private val getMovieUseCase: GetMovieUseCase,
    private val getDetailMovieUseCase: GetDetailMovieUseCase,
    private val getVideosUseCase: GetVideosUseCase,
    private val getReviewsUseCase: GetReviewsUseCase
) : ViewModel() {
    val genreMovie = MutableLiveData<Resource<GenreData>>()
    val movie = MutableLiveData<Resource<BaseResponseData<List<ListMoviesData>>>>()
    val videos = MutableLiveData<Resource<BaseResponseData<List<VideosData>>>>()
    val detailMovie = MutableLiveData<Resource<DetailMovieData>>()
    val reviews = MutableLiveData<Resource<BaseResponseData<List<ReviewData>>>>()

    fun getReviews(generalRequest: GeneralRequest) {
        viewModelScope.launch {
            getReviewsUseCase.invoke(generalRequest).collect {
                reviews.value = it
            }
        }
    }

    private fun getTopRatedMovie() {
        viewModelScope.launch {
            getTopRatedMovieUseCase.invoke(GeneralRequest(page = 1)).collect {

            }
        }
    }

    fun getMovie(generalRequest: GeneralRequest) {
        viewModelScope.launch {
            getMovieUseCase.invoke(generalRequest).collect {
                movie.value = it
            }
        }
    }

    fun getGenreMovie() {
        viewModelScope.launch {
            genreMovieUseCase.invoke().collect {
                genreMovie.value = it
            }
        }
    }

    fun getDetailMovie(generalRequest: GeneralRequest) {
        viewModelScope.launch {
            getDetailMovieUseCase.invoke(generalRequest).collect {
                detailMovie.value = it
            }
        }
    }

    fun getVideos(generalRequest: GeneralRequest) {
        viewModelScope.launch {
            getVideosUseCase.invoke(generalRequest).collect {
                videos.value = it
            }
        }
    }
}