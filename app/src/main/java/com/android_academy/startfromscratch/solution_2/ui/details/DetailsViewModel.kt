package com.android_academy.startfromscratch.solution_2.ui.details

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.solution_2.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.solution_3.di.DependencyInjection

interface DetailsViewModel {
    fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit)
    fun loadMovie(movieId: Int)
}

class DetailsViewModelImpl(private val moviesNetworkProvider: MovieNetworkProvider) : ViewModel(),
    DetailsViewModel {

    private val executors = DependencyInjection.viewModelExecutor

    private val movieLiveData = MutableLiveData<Movie>()

    override fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit) {
        movieLiveData.observe({ lifecycle }) {
            observer(it)
        }
    }

    override fun loadMovie(movieId: Int) {
        executors.execute {
            val movies = moviesNetworkProvider.getMovies() ?: return@execute
            val convertNetworkMovieToModel = MovieModelConverter.convertNetworkMovieToModel(movies)
            val movie = convertNetworkMovieToModel.firstOrNull { it.movieId == movieId }
            movie?.let {
                movieLiveData.postValue(movie)
            }
        }
    }
}

class DetailsViewModelFactory(private val moviesNetworkProvider: MovieNetworkProvider) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModelImpl::class.java)) {
            return DetailsViewModelImpl(moviesNetworkProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
