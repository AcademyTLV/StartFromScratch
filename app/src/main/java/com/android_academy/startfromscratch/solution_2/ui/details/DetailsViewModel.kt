package com.android_academy.startfromscratch.solution_2.ui.details

import androidx.lifecycle.*
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.solution_2.repository.MoviesRepository
import com.android_academy.startfromscratch.solution_2.ui.mainMovies.MoviesViewModelImpl
import com.android_academy.startfromscratch.solution_3.di.DependencyInjection
import kotlinx.coroutines.launch

interface DetailsViewModel {
    fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit)
    fun loadMovie(movieId : Int)
}

class DetailsViewModelImpl(private val moviesRepository: MoviesRepository) : ViewModel(),
    DetailsViewModel {

    private val executors = DependencyInjection.viewModelExecutor

    private val movieLiveData = MutableLiveData<Movie>()

    override fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit) {
        movieLiveData.observe({lifecycle}){
            observer(it)
        }
    }

    override fun loadMovie(movieId: Int) {
        executors.execute {
            moviesRepository.getMovie(movieId) { movie ->
                movie?.let {
                    movieLiveData.postValue(it)
                }
            }
        }
    }

}

class DetailsViewModelFactory(private val moviesRepository: MoviesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModelImpl::class.java)) {
            return DetailsViewModelImpl(moviesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
