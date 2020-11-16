package com.android_academy.startfromscratch.solution_5.movies.providers

import com.android_academy.network.MoviesListResult
import com.android_academy.network.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MovieNetworkProvider {
    suspend fun getMovies() : MoviesListResult
}

class MovieNetworkProviderImpl(private val service: MoviesService) : MovieNetworkProvider {

    override suspend fun getMovies(): MoviesListResult = withContext(Dispatchers.IO) {
        return@withContext service.latestMovies()
    }
}