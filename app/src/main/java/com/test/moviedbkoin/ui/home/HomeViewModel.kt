package com.test.moviedbkoin.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.core.data.Resource
import com.test.domain.model.credentials.GenreData
import com.test.domain.model.credentials.request.GeneralRequest
import com.test.domain.usecase.home.GetGenreMovieUseCase
import com.test.domain.usecase.home.GetTopRatedMovieUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val genreMovieUseCase: GetGenreMovieUseCase,
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase
) : ViewModel() {
    val genreMovie = MutableLiveData<Resource<GenreData>>()

    init {
        getTopRatedMovie()
    }

    private fun getTopRatedMovie() {
        viewModelScope.launch {
            getTopRatedMovieUseCase.invoke(GeneralRequest(page = 1)).collect {

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
}