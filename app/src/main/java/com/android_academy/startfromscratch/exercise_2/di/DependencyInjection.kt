package com.android_academy.startfromscratch.exercise_2.di

import com.android_academy.network.di.MockNetworkDependency
import com.android_academy.startfromscratch.exercise_2.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.exercise_2.providers.MovieNetworkProviderImpl
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

object DependencyInjection {
    //I'm tired of implementing safe thread for all this manual dependency injection.
    val networkProvider: MovieNetworkProvider =
        MovieNetworkProviderImpl(MockNetworkDependency.movieService)

    val viewModelExecutor: ThreadPoolExecutor =
        Executors.newFixedThreadPool(10) as ThreadPoolExecutor
}