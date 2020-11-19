package com.android_academy.startfromscratch.solution_2.di

import com.android_academy.db.di.MockDBDependency
import com.android_academy.network.di.MockNetworkDependency
import com.android_academy.startfromscratch.MoviesApp
import com.android_academy.startfromscratch.solution_2.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.solution_2.providers.MovieDatabaseProviderImpl
import com.android_academy.startfromscratch.solution_2.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.solution_2.providers.MovieNetworkProviderImpl
import com.android_academy.startfromscratch.solution_2.repository.MoviesRepository
import com.android_academy.startfromscratch.solution_2.repository.MoviesRepositoryImpl
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

object DependencyInjection {
    //I'm tired of implementing safe thread for all this manual dependency injection.
    val dbProvider: MovieDatabaseProvider =
        MovieDatabaseProviderImpl(MockDBDependency.getMoviesDao())

    val repoExecutor: ThreadPoolExecutor = Executors.newFixedThreadPool(10) as ThreadPoolExecutor

    val networkProvider: MovieNetworkProvider =
        MovieNetworkProviderImpl(MockNetworkDependency.movieService)

    val moviesRepo: MoviesRepository =
        MoviesRepositoryImpl(dbProvider, networkProvider, repoExecutor)

    val viewModelExecutor: ThreadPoolExecutor =
        Executors.newFixedThreadPool(10) as ThreadPoolExecutor
}