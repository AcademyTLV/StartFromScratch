package com.android_academy.db.di

import android.content.Context
import com.android_academy.db.Movie
import java.util.concurrent.ConcurrentHashMap

object MockDBDependency {

    val data : ConcurrentHashMap<Int, Movie> = ConcurrentHashMap()

    fun getMoviesDao() : MockMovieDao {
        return object : MockMovieDao {
            override fun getAll(): List<Movie>? {
                return data.values.toList()
            }

            override fun getMovie(movieId: Int): Movie? {
                return data[movieId]
            }

            override fun insertAll(movies: Collection<Movie>) {
                deleteAll()
                data.putAll(movies.associateBy { it.movieId })
            }

            override fun deleteAll() {
                data.clear()
            }

        }
    }

}

interface MockMovieDao {
    fun getAll(): List<Movie>?
    fun getMovie(movieId: Int): Movie?
    fun insertAll(movies: Collection<Movie>)
    fun deleteAll()
}
