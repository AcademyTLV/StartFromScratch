package com.android_academy.startfromscratch.solution_3.providers

import com.android_academy.db.MovieDao
import com.android_academy.db.Movie
import com.android_academy.db.di.MockMovieDao

interface MovieDatabaseProvider {

    fun getAll(): List<Movie>?
    fun getMovie(movieId : Int): Movie?
    fun insertAll(movies: List<Movie>)
    fun deleteAll()
}

class MovieDatabaseProviderImpl(private val dao: MockMovieDao) : MovieDatabaseProvider {

    override fun getAll(): List<Movie>? {
        return dao.getAll()
    }

    override fun getMovie(movieId: Int): Movie? {
        return dao.getMovie(movieId)
    }

    override fun insertAll(movies: List<Movie>) {
        dao.insertAll(movies)
    }

    override fun deleteAll() {
        dao.deleteAll()
    }
}