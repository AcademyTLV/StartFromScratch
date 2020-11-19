@file:Suppress("RemoveExplicitTypeArguments")

package com.android_academy.startfromscratch.exercise_5.di

import com.android_academy.db.di.dbModule
import com.android_academy.network.di.networkingModule


val exercise5modulesList = listOf(
    networkingModule,
    dbModule,
    viewModelsModule
//TODO add here our reposModule from ReposModule.kt
)
