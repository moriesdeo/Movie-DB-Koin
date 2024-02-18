package com.test.moviedbkoin.module

import com.test.data.home.GenreMapper
import com.test.data.home.ListGenreMovieMapper
import com.test.data.home.ListTopRatedMovieDataMapper
import com.test.data.home.ListTopRatedMoviesMapper
import com.test.data.movie.DetailMovieMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { ListGenreMovieMapper(get()) }
    factory { GenreMapper() }
    factory { ListTopRatedMovieDataMapper() }
    factory { ListTopRatedMoviesMapper(get()) }
    factory { DetailMovieMapper() }
}