package com.android_academy.startfromscratch.solution_5.movies.di

import com.android_academy.startfromscratch.solution_5.movies.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.solution_5.movies.providers.MovieDatabaseProviderImpl
import com.android_academy.startfromscratch.solution_5.movies.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.solution_5.movies.providers.MovieNetworkProviderImpl
import com.android_academy.startfromscratch.solution_5.movies.repository.MoviesRepository
import com.android_academy.startfromscratch.solution_5.movies.repository.MoviesRepositoryImpl
import org.koin.dsl.module


val reposModule = module {

    single<MoviesRepository> {
        MoviesRepositoryImpl(
            dbProvider = get(),
            networkProvider = get()
        )
    }

    single<MovieNetworkProvider> {
        MovieNetworkProviderImpl(get())
    }

    single<MovieDatabaseProvider> {
        MovieDatabaseProviderImpl(get())
    }
}