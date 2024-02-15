package com.test.moviedbkoin.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.core.data.Resource
import com.test.core.extension.data
import com.test.domain.model.credentials.GenreData
import com.test.domain.usecase.home.GetGenreMovieUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val genreMovieUseCase: GetGenreMovieUseCase
) : ViewModel() {

    val genreMovie = MutableLiveData<Resource<GenreData>>()
    fun getGenreMovie() {
        viewModelScope.launch {
            genreMovieUseCase.invoke().collect {
                genreMovie.value = it
            }
        }
    }
}