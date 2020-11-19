
package com.android_academy.startfromscratch.exercise_5.di

import android.util.Log
import com.android_academy.startfromscratch.exercise_5.repository.MoviesRepository
import com.android_academy.startfromscratch.exercise_5.ui.details.DetailsViewModelImpl
import com.android_academy.startfromscratch.exercise_5.ui.mainMovies.MoviesViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.*

val viewModelsModule = module {

    viewModel {
        Log.d("viewModelsModule", "creating viewModel: MoviesViewModelImpl")
        MoviesViewModelImpl(
            //TODO change it to "get()" method. It will find what the right class and dependecy to it
            moviesRepository = Object() as MoviesRepository
        )
    }

    //TODO Add here viewModel block to provide our DetailsViewModelImpl with moviesRepository dependency
    //see viewModel above as a reference
}
