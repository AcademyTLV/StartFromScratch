package com.android_academy.startfromscratch.solution_5.repository

import android.util.Log
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.solution_5.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.solution_5.providers.MovieNetworkProvider
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.coroutineContext

interface MoviesRepository {
    suspend fun getMovies(callback: (List<Movie>?) -> Unit)
    suspend fun getMovie(movieId : Int, callback: (Movie?) -> Unit)
}


class MoviesRepositoryImpl(
    private val dbProvider: MovieDatabaseProvider,
    private val networkProvider: MovieNetworkProvider
) : MoviesRepository {

    override suspend fun getMovies(callback: (List<Movie>?) -> Unit) {
        withContext(coroutineContext + Dispatchers.IO) {
            getMoviesFromDataBase(callback)
            getMoviesFromServer()
        }
    }

    override suspend fun getMovie(movieId: Int, callback: (Movie?) -> Unit) {
        withContext(coroutineContext + Dispatchers.IO) {
            val movie = dbProvider.getMovie(movieId)
            callback.invoke(movie)
        }
    }

    private suspend fun getMoviesFromServer() {
        try {
            CoroutineScope(coroutineContext).launch {
                val movies = networkProvider.getMovies()
                Log.d("[MoviesRepositoryImpl]", "getMoviesFromServerCoroutines(): $movies")
                dbProvider.deleteAll()
                dbProvider.insertAll(MovieModelConverter.convertNetworkMovieToModel(movies))
            }
        } catch (cause: Throwable) {
            Log.d("MoviesRepository", "On failure: ${cause.message}")
        }
    }

    private suspend fun getMoviesFromDataBase(callback: (List<Movie>?) -> Unit) {
        CoroutineScope(coroutineContext).launch {
            dbProvider.getAll().collect {
                callback(it)
            }
        }
    }
}