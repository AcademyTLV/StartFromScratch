package com.android_academy.startfromscratch.exercise_5.di

import com.android_academy.startfromscratch.exercise_5.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.exercise_5.providers.MovieDatabaseProviderImpl
import com.android_academy.startfromscratch.exercise_5.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.exercise_5.providers.MovieNetworkProviderImpl
import com.android_academy.startfromscratch.exercise_5.repository.MoviesRepository
import com.android_academy.startfromscratch.exercise_5.repository.MoviesRepositoryImpl
import org.koin.dsl.module


val reposModule = module {

    //TODO change it to single since we want our repo to be a singleton
    factory<MoviesRepository> {
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