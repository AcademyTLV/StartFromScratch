package com.android_academy.db.di

import android.content.Context
import com.android_academy.db.AppDatabase
import com.android_academy.db.MovieDao
import org.koin.android.ext.koin.androidContext

object DBDependency {
    lateinit var db : AppDatabase
    private fun createDB(context : Context) : AppDatabase {
        if(::db.isInitialized) db
        synchronized(this) {
            db = AppDatabase.create(context)
        }
        return db
    }

    fun getMoviesDao(context: Context) : MovieDao {
        return createDB(context).movieDao()
    }
}