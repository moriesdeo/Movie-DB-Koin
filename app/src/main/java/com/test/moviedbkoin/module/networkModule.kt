package com.test.moviedbkoin.module

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.GsonBuilder
import com.test.moviedbkoin.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    val cacheSize = (10 * 1024 * 1024).toLong() // 10mb
    val READ_TIMEOUT = 180.toLong() // 3 min
    val CONNECT_TIMEOUT = 180.toLong() // 3 min

    single { GsonBuilder().create() }
    single {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        OkHttpClient.Builder().apply {
            cache(Cache(androidContext().cacheDir, cacheSize))
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(logging)
            addInterceptor(createChuckerInterceptor(androidContext()))
        }.build()
    }

    single<Retrofit>(named("MOVIE_BASE_URL")) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.MOVIE_BASE_URL + BuildConfig.TSDB_API_KEY)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }
}

private fun createChuckerInterceptor(context: Context): ChuckerInterceptor {
    // Create the Interceptor
    return ChuckerInterceptor.Builder(context)
        // The max body content length in bytes, after this responses will be truncated.
        .maxContentLength(250_000L)
        .alwaysReadResponseBody(true)
        .build()
}