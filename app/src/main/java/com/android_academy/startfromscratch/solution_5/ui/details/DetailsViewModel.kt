package com.android_academy.startfromscratch.solution_5.ui.details

import androidx.lifecycle.*
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.solution_5.repository.MoviesRepository
import kotlinx.coroutines.launch

interface DetailsViewModel {
    fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit)
    fun loadMovie(movieId : Int)
}

class DetailsViewModelImpl(private val moviesRepository: MoviesRepository) : ViewModel(),
    DetailsViewModel {

    private val movieLiveData = MutableLiveData<Movie>()

    override fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit) {
        movieLiveData.observe({lifecycle}){
            observer(it)
        }
    }

    override fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            moviesRepository.getMovie(movieId) { movie ->
                movie?.let {
                    movieLiveData.postValue(it)
                }
            }
        }
    }

}