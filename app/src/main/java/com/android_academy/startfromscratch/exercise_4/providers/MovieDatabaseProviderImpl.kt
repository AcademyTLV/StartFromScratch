package com.android_academy.startfromscratch.exercise_4.providers

import com.android_academy.db.MovieDao
import com.android_academy.db.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface MovieDatabaseProvider {

    fun getAll(): Flow<List<Movie>?>
    fun getMovie(movieId : Int): Movie?
    suspend fun insertAll(movies: List<Movie>)
    suspend fun deleteAll() = Unit
}

class MovieDatabaseProviderImpl(private val dao: MovieDao) : MovieDatabaseProvider {

    override fun getAll(): Flow<List<Movie>?> {
        return dao.getAll()
    }

    override fun getMovie(movieId: Int): Movie?  {
        //TODO add withContext + Dispatchers.IO for mainThreadSafety
        return dao.getMovie(movieId)
    }

    override suspend fun insertAll(movies: List<Movie>) = withContext(Dispatchers.IO) {
        dao.insertAll(movies)
    }
}