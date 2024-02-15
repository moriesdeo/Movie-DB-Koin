package com.test.moviedbkoin.module

import com.test.domain.usecase.home.GetGenreMovieUseCase
import com.test.domain.usecase.home.GetTopRatedMovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetGenreMovieUseCase(get()) }
    single { GetTopRatedMovieUseCase(get()) }
}