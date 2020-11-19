package com.android_academy.startfromscratch

import android.app.Application
import android.content.Context
import com.android_academy.startfromscratch.solution_5.di.modulesList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MoviesApp : Application() {
    init {
        instance = this
    }

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

    companion object {
        private var instance: MoviesApp? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}