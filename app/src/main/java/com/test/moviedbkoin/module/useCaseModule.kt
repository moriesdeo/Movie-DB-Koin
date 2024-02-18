package com.test.moviedbkoin.module

import com.test.domain.usecase.home.GetGenreMovieUseCase
import com.test.domain.usecase.movie.GetDetailMovieUseCase
import com.test.domain.usecase.movie.GetMovieUseCase
import com.test.domain.usecase.movie.GetTopRatedMovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetGenreMovieUseCase(get()) }
    single { GetTopRatedMovieUseCase(get()) }
    single { GetMovieUseCase(get()) }
    single { GetDetailMovieUseCase(get()) }
}