package com.android_academy.startfromscratch.exercise_1.network

import com.google.gson.Gson

//TODO Exercise #1 move it to network module and replace import in DependencyInjection
object MockNetworkDependency {
    val movieService = object : MockMovieService {
        override fun latestMovies(year: Int, apiKey: String): MoviesListResult {
            val gson = Gson()
            return gson.fromJson(mockData, MoviesListResult::class.java)
        }
    }
}