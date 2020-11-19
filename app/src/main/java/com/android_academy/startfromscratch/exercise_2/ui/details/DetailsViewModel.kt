package com.android_academy.startfromscratch.exercise_2.ui.details

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.exercise_2.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.solution_3.di.DependencyInjection

interface DetailsViewModel {
    fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit)
    fun loadMovie(movieId: Int)
}

//TODO make DetailsViewModelImpl extending ViewModel abstract class.
//TODO implement all methods from DetailsViewModel interface
class DetailsViewModelImpl(private val moviesNetworkProvider: MovieNetworkProvider) : ViewModel(),
    DetailsViewModel {

    private val executors = DependencyInjection.viewModelExecutor

    private val movieLiveData = MutableLiveData<Movie>()

    override fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit) {
        //TODO Start observation of movie via movieLiveData (check observeMovies() in MoviesViewModelImpl for reference)
        //TODO update observer on every changes
    }

    override fun loadMovie(movieId: Int) {
        executors.execute {
            //TODO 1. Load data view moviesNetworkProvider.getMovies()
            //TODO 2. Convert MoviesListResult to List<Movie>
            //TODO 3. Find movie with a requested movieId
            //TODO 4. Update live data with a movie object
        }
    }
}
