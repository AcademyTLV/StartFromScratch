package com.android_academy.startfromscratch

import android.app.Application
import android.content.Context
import com.android_academy.startfromscratch.exercise_5.di.exercise5modulesList
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
            //TODO Add to loadModules exercise5modulesList from di package in exercise_5
            koin.loadModules(modulesList)
            koin.createRootScope()
        }
    }

    companion object {
        private var instance: MoviesApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}