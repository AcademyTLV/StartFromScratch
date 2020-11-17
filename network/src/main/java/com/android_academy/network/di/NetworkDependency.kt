package com.android_academy.network.di

import com.android_academy.network.MoviesService
import com.android_academy.network.NetworkingConstants
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkDependency {
    val gson = lazy { Gson() }

    val retrofit = lazy {
        Retrofit.Builder()
            .baseUrl(NetworkingConstants.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson.value))
            .build()
    }

    val movieService = lazy { retrofit.value.create(MoviesService::class.java) }
}