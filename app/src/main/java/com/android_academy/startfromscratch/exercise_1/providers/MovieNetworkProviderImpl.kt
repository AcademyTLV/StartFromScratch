package com.android_academy.startfromscratch.exercise_1.providers

import com.android_academy.network.MoviesListResult
import com.android_academy.network.di.MockMovieService

interface MovieNetworkProvider {
    fun getMovies(): MoviesListResult?
}

class MovieNetworkProviderImpl(private val service: MockMovieService) : MovieNetworkProvider {

    override fun getMovies(): MoviesListResult? {
        return try {
            service.latestMovies()
        } catch (e: Throwable) {
            null
        }
    }
}