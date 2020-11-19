package com.android_academy.startfromscratch.solution_5.ui.mainMovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android_academy.db.Movie
import androidx.lifecycle.viewModelScope
import com.android_academy.startfromscratch.solution_5.repository.MoviesRepository
import kotlinx.coroutines.launch

enum class State { LOADING, LOADED, ERROR }

interface MoviesViewModel {
    val likedMoviesLiveData: LiveData<List<Movie>>
    fun getState(): LiveData<State>
    fun getMovies(): LiveData<List<Movie>>
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
