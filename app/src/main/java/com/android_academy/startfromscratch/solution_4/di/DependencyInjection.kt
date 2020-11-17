package com.android_academy.startfromscratch.solution_4.di

import android.app.Application
import com.android_academy.db.di.DBDependency
import com.android_academy.network.di.NetworkDependency
import com.android_academy.startfromscratch.MoviesApp
import com.android_academy.startfromscratch.solution_4.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.solution_4.providers.MovieDatabaseProviderImpl
import com.android_academy.startfromscratch.solution_4.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.solution_4.providers.MovieNetworkProviderImpl
import com.android_academy.startfromscratch.solution_4.repository.MoviesRepository
import com.android_academy.startfromscratch.solution_4.repository.MoviesRepositoryImpl

object DependencyInjection {
    //I'm tired of implementing safe thread for all this manual dependency injection.
    val dbProvider : MovieDatabaseProvider = MovieDatabaseProviderImpl(DBDependency.getMoviesDao(MoviesApp.applicationContext()))
    val networkProvider : MovieNetworkProvider = MovieNetworkProviderImpl(NetworkDependency.movieService.value)
    val moviesRepo : MoviesRepository = MoviesRepositoryImpl(dbProvider, networkProvider)
}