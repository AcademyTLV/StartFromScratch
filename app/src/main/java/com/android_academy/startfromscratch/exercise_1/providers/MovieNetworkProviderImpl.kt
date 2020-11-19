package com.android_academy.startfromscratch.exercise_1.providers

import com.android_academy.startfromscratch.exercise_1.network.MockMovieService
import com.android_academy.startfromscratch.exercise_1.network.MoviesListResult

interface MovieNetworkProvider {
    fun getMovies(): MoviesListResult?
}

//TODO Exercise #1 after you move MockMovieService to separate network module change import to use it from new network module
class MovieNetworkProviderImpl(private val service: MockMovieService) : MovieNetworkProvider {

    override fun getMovies(): MoviesListResult? {
        return try {
            service.latestMovies()
        } catch (e: Throwable) {
            null
        }
    }
}