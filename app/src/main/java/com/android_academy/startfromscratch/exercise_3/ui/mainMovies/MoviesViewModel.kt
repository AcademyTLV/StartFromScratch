package com.android_academy.startfromscratch.exercise_3.ui.mainMovies

import androidx.lifecycle.*
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.exercise_3.di.DependencyInjection
import com.android_academy.startfromscratch.exercise_3.repository.MoviesRepository

enum class State { LOADING, LOADED, ERROR }

interface MoviesViewModel {
    val likedMoviesLiveData: LiveData<List<Movie>>
    fun getState(): LiveData<State>
    fun observeMovies(lifecycle: Lifecycle,observer : (List<Movie>) -> Unit)
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

    private val executors = DependencyInjection.viewModelExecutor

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
        executors.execute {
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
