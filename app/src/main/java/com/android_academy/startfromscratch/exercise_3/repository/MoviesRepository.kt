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
}


class MoviesRepositoryImpl(
    private val dbProvider: MovieDatabaseProvider,
    private val networkProvider: MovieNetworkProvider,
    private val executor: ThreadPoolExecutor
) : MoviesRepository {

    override fun getMovies(callback: (List<Movie>?) -> Unit) {
        //TODO call for getMoviesFromServer
        //TODO after movies in db call for getMoviesFromDB
        //Notice that it's not waiting one for each other. It's open two new threads and do it concurrently
    }

    override fun getMovie(movieId: Int, callback: (Movie?) -> Unit) {
        executor.execute {
            val movie = dbProvider.getMovie(movieId)
            callback.invoke(movie)
        }
    }

    fun getMoviesFromServer(callback: (List<Movie>?) -> Unit) {
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

    fun getMoviesFromDataBase(callback: (List<Movie>?) -> Unit) {
        executor.execute {
            callback(dbProvider.getAll())
        }
    }
}