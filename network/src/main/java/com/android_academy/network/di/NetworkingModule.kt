package com.android_academy.network.di

import com.android_academy.network.MoviesService
import com.android_academy.network.NetworkingConstants
import com.google.gson.Gson
import org.koin.dsl.module
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory


val networkingModule = module {

    single<Retrofit> {
        val gson = get<Gson>()

        return@single Retrofit.Builder()
            .baseUrl(NetworkingConstants.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    single {
        Gson()
    }

    factory<MoviesService> {
        val retrofit = get<Retrofit>()
        return@factory retrofit.create(MoviesService::class.java)
    }

}
