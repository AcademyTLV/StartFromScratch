@file:Suppress("RemoveExplicitTypeArguments")

package com.android_academy.startfromscratch.solution_5.di

import com.android_academy.db.di.dbModule
import com.android_academy.network.di.networkingModule


val modulesList = listOf(
    networkingModule,
    dbModule,
    viewModelsModule,
    reposModule
)
