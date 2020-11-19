package com.android_academy.startfromscratch.exercise_1.ui.mainMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.R
import com.android_academy.startfromscratch.exercise_1.di.DependencyInjection
import com.android_academy.startfromscratch.exercise_1.ui.details.DetailsFragment
import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(), OnMovieClickListener {

    private val executors = DependencyInjection.viewModelExecutor
    private val moviesNetworkProvider = DependencyInjection.networkProvider

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var moviesAdapter: MoviesViewAdapter
    lateinit var moviesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        loadData()
        updateUI()
    }

    private fun updateUI() {
        activity!!.title = "Movies"
    }

    private fun loadData() {
        executors.execute {
            setState(State.LOADING)
            val movies = moviesNetworkProvider.getMovies()
            if (movies == null) {
                setState(State.ERROR)
                return@execute
            }
            val convertNetworkMovieToModel = MovieModelConverter.convertNetworkMovieToModel(movies)
            setState(State.LOADED)
            moviesAdapter.setData(convertNetworkMovieToModel)
        }
    }

    private fun initRecyclerView() {
        moviesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        moviesAdapter = MoviesViewAdapter(this)
        moviesRecyclerView.adapter = moviesAdapter
    }

    private fun setState(state: State) {
        view?.post {
            when (state) {
                State.LOADING -> moviesProgress.visibility = View.VISIBLE
                State.LOADED -> moviesProgress.visibility = View.GONE
                State.ERROR -> {
                    moviesProgress.visibility = View.GONE
                    Toast.makeText(this.requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onMovieClicked(movie: Movie, adapterPosition: Int) {
        val detailsFragment = DetailsFragment.newInstance(movie)
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, detailsFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack("main").commit()
    }
}
