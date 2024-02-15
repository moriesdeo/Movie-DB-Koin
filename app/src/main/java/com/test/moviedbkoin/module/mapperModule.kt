package com.test.moviedbkoin.module

import com.test.data.home.GenreMapper
import com.test.data.home.ListGenreMovieMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { ListGenreMovieMapper(get()) }
    factory { GenreMapper() }
}