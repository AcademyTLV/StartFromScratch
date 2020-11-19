package com.android_academy.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getAll(): Flow<List<Movie>?>

    @Query("SELECT * FROM Movie WHERE movieId = :movieId")
    fun getMovie(movieId: Int): Movie?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: Collection<Movie>)

    @Query("DELETE FROM Movie")
    suspend fun deleteAll()
}