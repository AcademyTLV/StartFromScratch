package com.android_academy.startfromscratch.solution_5.ui.mainMovies

import androidx.lifecycle.*
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.solution_5.repository.MoviesRepository
import kotlinx.coroutines.launch

enum class State { LOADING, LOADED, ERROR }

interface MoviesViewModel {
    val likedMoviesLiveData: LiveData<List<Movie>>
    fun getState(): LiveData<State>
    fun observeMovies(lifecycle: Lifecycle,observer : (List<Movie>) -> Unit)
}


class MoviesViewModelImpl(val moviesRepository: MoviesRepository) : MoviesViewModel, ViewModel() {

    private val _likedMovies = MutableLiveData<List<Movie>>()

    override val likedMoviesLiveData: LiveData<List<Movie>>
        get() = _likedMovies


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

    override fun observeMovies(lifecycle: Lifecycle, observer: (List<Movie>) -> Unit) {
        movies.observe({lifecycle}) {
            observer(it)
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
