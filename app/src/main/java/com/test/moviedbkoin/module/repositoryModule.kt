package com.test.moviedbkoin.module

import com.test.data.repository.HomeRepositoryImpl
import com.test.domain.repository.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MoviesRepository> {
        HomeRepositoryImpl(get(), get(), get(), get(), get(), get())
    }
}