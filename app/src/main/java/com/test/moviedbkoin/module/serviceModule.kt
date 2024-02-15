package com.test.moviedbkoin.module

import com.test.data.service.HomeService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    factory { get<Retrofit>(qualifier = named("MOVIE_BASE_URL")).create(HomeService::class.java) }
}