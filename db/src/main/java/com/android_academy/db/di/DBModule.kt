package com.android_academy.db.di
import com.android_academy.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {

    single {
        AppDatabase.create(androidContext())
    }

    factory {
        get<AppDatabase>().movieDao()
    }


}
