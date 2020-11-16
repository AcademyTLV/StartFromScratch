
package com.android_academy.startfromscratch.solution_5.movies.di

import android.util.Log
import com.android_academy.startfromscratch.solution_5.movies.ui.details.DetailsViewModelImpl
import com.android_academy.startfromscratch.solution_5.movies.ui.mainMovies.MoviesViewModelImpl
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
