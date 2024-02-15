package com.test.moviedbkoin.module

import com.test.domain.usecase.home.GetGenreMovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetGenreMovieUseCase(get()) }
}