package com.test.moviedbkoin.module

import com.test.data.repository.HomeRepositoryImpl
import com.test.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> {
        HomeRepositoryImpl(get(), get())
    }
}