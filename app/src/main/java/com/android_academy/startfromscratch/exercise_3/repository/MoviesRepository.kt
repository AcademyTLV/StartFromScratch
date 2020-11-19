package com.android_academy.startfromscratch.exercise_3.repository

import android.util.Log
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.exercise_3.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.exercise_3.providers.MovieNetworkProvider
import java.util.concurrent.ThreadPoolExecutor

interface MoviesRepository {
    fun getMovies(callback: (List<Movie>?) -> Unit)
    fun getMovie(movieId: Int, callback: (Movie?) -> Unit)
    fun getMoviesFromServerCoroutines(callback: (List<Movie>?) -> Unit)
    fun getMoviesFromDataBase(callback: (List<Movie>?) -> Unit)
}


class MoviesRepositoryImpl(
    private val dbProvider: MovieDatabaseProvider,
    private val networkProvider: MovieNetworkProvider,
    private val executor: ThreadPoolExecutor
) : MoviesRepository {

    override fun getMovies(callback: (List<Movie>?) -> Unit) {
        getMoviesFromDataBase(callback)
        getMoviesFromServerCoroutines(callback)
    }

    override fun getMovie(movieId: Int, callback: (Movie?) -> Unit) {
        executor.execute {
            val movie = dbProvider.getMovie(movieId)
            callback.invoke(movie)
        }
    }

    override fun getMoviesFromServerCoroutines(callback: (List<Movie>?) -> Unit) {
        try {
            executor.execute {
                val movies = networkProvider.getMovies()
                Log.d("[MoviesRepositoryImpl]", "getMoviesFromServerCoroutines(): $movies")
                dbProvider.insertAll(MovieModelConverter.convertNetworkMovieToModel(movies))
                getMoviesFromDataBase(callback)
            }
        } catch (cause: Throwable) {
            Log.d("MoviesRepository", "On failure: ${cause.message}")
        }
    }

    override fun getMoviesFromDataBase(callback: (List<Movie>?) -> Unit) {
        executor.execute {
            callback(dbProvider.getAll())
        }
    }
}