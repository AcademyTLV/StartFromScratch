package com.android_academy.startfromscratch

import android.app.Application
import com.android_academy.startfromscratch.solution_5.movies.di.modulesList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MoviesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MoviesApp)
            koin.loadModules(modulesList)
            koin.createRootScope()
        }
    }
}