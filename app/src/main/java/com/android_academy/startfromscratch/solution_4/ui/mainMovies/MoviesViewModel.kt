package com.android_academy.startfromscratch.solution_4.ui.mainMovies

import androidx.lifecycle.*
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.solution_4.repository.MoviesRepository
import kotlinx.coroutines.launch

enum class State { LOADING, LOADED, ERROR }

interface MoviesViewModel {
    val likedMoviesLiveData: LiveData<List<Movie>>
    fun getState(): LiveData<State>
    fun getMovies(): LiveData<List<Movie>>
}

class MoviesViewModelFactory(private val moviesRepository: MoviesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModelImpl::class.java)) {
            return MoviesViewModelImpl(moviesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


class MoviesViewModelImpl(val moviesRepository: MoviesRepository) : MoviesViewModel, ViewModel() {

    private val _likedMovies = MutableLiveData<List<Movie>>()

    override val likedMoviesLiveData: LiveData<List<Movie>>
        get() = _likedMovies

    override fun getMovies(): LiveData<List<Movie>> = movies


    // State
    private val state: MutableLiveData<State> by lazy { MutableLiveData<State>() }

    override fun getState(): LiveData<State> = state


    // Movies
    private val movies: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>().also {
            state.postValue(State.LOADING)
            loadMovies()
        }
    }

    private fun loadMovies() {
        viewModelScope.launch {
            moviesRepository.getMovies {
                if (it == null) {
                    state.postValue(State.ERROR)
                }

                if (it?.isNotEmpty() == true) {
                    state.postValue(State.LOADED)
                }
                movies.postValue(it)
            }
        }
    }
}
