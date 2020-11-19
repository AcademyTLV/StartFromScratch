package com.android_academy.startfromscratch.exercise_4.repository

import android.util.Log
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.exercise_4.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.exercise_4.providers.MovieNetworkProvider
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.coroutineContext

interface MoviesRepository {
    suspend fun getMovies(callback: (List<Movie>?) -> Unit)
    fun getMovie(movieId : Int, callback: (Movie?) -> Unit)
    suspend fun getMoviesFromServerCoroutines()
    suspend fun getMoviesFromDataBase(callback: (List<Movie>?) -> Unit)
}


class MoviesRepositoryImpl(
    private val dbProvider: MovieDatabaseProvider,
    private val networkProvider: MovieNetworkProvider
) : MoviesRepository {

    override suspend fun getMovies(callback: (List<Movie>?) -> Unit) {
        withContext(coroutineContext + Dispatchers.IO) {
            getMoviesFromDataBase(callback)
            getMoviesFromServerCoroutines()
        }
    }

    override fun getMovie(movieId: Int, callback: (Movie?) -> Unit) {
        //TODO Add withContext Dispatchers.IO to ensure MainThreadSafety
            val movie = dbProvider.getMovie(movieId)
            callback.invoke(movie)
    }

    override suspend fun getMoviesFromServerCoroutines() {
        try {
            CoroutineScope(coroutineContext).launch {
                val movies = networkProvider.getMovies()
                Log.d("[MoviesRepositoryImpl]", "getMoviesFromServerCoroutines(): $movies")
                //TODO Add deleteAll from database after you create it in MovieDatabaseProviderImpl and DAO
                dbProvider.insertAll(MovieModelConverter.convertNetworkMovieToModel(movies))

            }
        } catch (cause: Throwable) {
            Log.d("MoviesRepository", "On failure: ${cause.message}")
        }
    }

    override suspend fun getMoviesFromDataBase(callback: (List<Movie>?) -> Unit) {
        CoroutineScope(coroutineContext).launch {
            dbProvider.getAll().collect {
                callback(it)
            }
        }
    }
}