package com.android_academy.startfromscratch.exercise_3.providers

import com.android_academy.network.MoviesListResult
import com.android_academy.network.MoviesService
import com.android_academy.network.di.MockMovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MovieNetworkProvider {
    fun getMovies() : MoviesListResult
}

class MovieNetworkProviderImpl(private val service: MockMovieService) : MovieNetworkProvider {

    override fun getMovies(): MoviesListResult {
        return service.latestMovies()
    }
}