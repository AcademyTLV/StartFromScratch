package com.android_academy.startfromscratch.solution_2.ui.mainMovies

import androidx.lifecycle.*
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.solution_2.di.DependencyInjection
import com.android_academy.startfromscratch.solution_2.providers.MovieNetworkProvider

enum class State { LOADING, LOADED, ERROR }

interface MoviesViewModel {
    val likedMoviesLiveData: LiveData<List<Movie>>
    fun getState(): LiveData<State>
    fun observeMovies(lifecycle: Lifecycle,observer : (List<Movie>) -> Unit)
}

class MoviesViewModelFactory(private val moviesNetworkProvider: MovieNetworkProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModelImpl::class.java)) {
            return MoviesViewModelImpl(moviesNetworkProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


class MoviesViewModelImpl(private val moviesNetworkProvider: MovieNetworkProvider) : MoviesViewModel, ViewModel() {

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
            val moviesListResult = moviesNetworkProvider.getMovies()
                if (moviesListResult == null) {
                    state.postValue(State.ERROR)
                    return@execute
                }

                if (moviesListResult.results.isNotEmpty()) {
                    state.postValue(State.LOADED)
                }
            val convertNetworkMovieToModel =
                MovieModelConverter.convertNetworkMovieToModel(moviesListResult)
            movies.postValue(convertNetworkMovieToModel)
        }
    }
}
