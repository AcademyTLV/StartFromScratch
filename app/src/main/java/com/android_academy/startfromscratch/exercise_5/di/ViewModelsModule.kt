
package com.android_academy.startfromscratch.exercise_5.di

import android.util.Log
import com.android_academy.startfromscratch.exercise_5.ui.details.DetailsViewModelImpl
import com.android_academy.startfromscratch.exercise_5.ui.mainMovies.MoviesViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        Log.d("viewModelsModule", "creating viewModel: MoviesViewModelImpl")
        MoviesViewModelImpl(
            moviesRepository = get()
        )
    }

    viewModel {
        DetailsViewModelImpl(
            moviesRepository = get()
        )
    }
}
