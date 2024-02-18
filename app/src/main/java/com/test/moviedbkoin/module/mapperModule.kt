package com.test.moviedbkoin.module

import com.test.data.home.GenreMapper
import com.test.data.home.ListGenreMovieMapper
import com.test.data.home.ListTopRatedMovieDataMapper
import com.test.data.home.ListTopRatedMoviesMapper
import com.test.data.home.ProductionCompaniesMapper
import com.test.data.home.ProductionCountryMapper
import com.test.data.home.SpokenLanguageMapper
import com.test.data.movie.DetailMovieMapper
import com.test.data.movie.ListMovieMapper
import com.test.data.movie.VideosMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { ListGenreMovieMapper(get()) }
    factory { GenreMapper() }
    factory { ListTopRatedMovieDataMapper() }
    factory { ProductionCompaniesMapper() }
    factory { ProductionCountryMapper() }
    factory { SpokenLanguageMapper() }
    factory { ListMovieMapper() }
    factory { VideosMapper(get()) }
    factory { ListTopRatedMoviesMapper(get()) }
    factory { DetailMovieMapper(get(), get(), get(), get()) }
}