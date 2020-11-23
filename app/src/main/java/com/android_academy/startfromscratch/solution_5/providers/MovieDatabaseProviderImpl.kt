package com.android_academy.startfromscratch.solution_5.providers

import com.android_academy.db.MovieDao
import com.android_academy.db.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface MovieDatabaseProvider {

    fun getAll(): Flow<List<Movie>?>
    suspend fun getMovie(movieId : Int): Movie?
    suspend fun insertAll(movies: List<Movie>)
    suspend fun deleteAll()
}

class MovieDatabaseProviderImpl(private val dao: MovieDao) : MovieDatabaseProvider {

    override fun getAll(): Flow<List<Movie>?> {
        return dao.getAll()
    }

    override suspend fun getMovie(movieId: Int): Movie? = withContext(Dispatchers.IO) {
        return@withContext dao.getMovie(movieId)
    }

    override suspend fun insertAll(movies: List<Movie>) = withContext(Dispatchers.IO) {
        dao.insertAll(movies)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}