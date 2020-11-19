package com.android_academy.startfromscratch.solution_2.ui.mainMovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.R
import com.android_academy.startfromscratch.solution_2.di.DependencyInjection
import com.android_academy.startfromscratch.solution_2.ui.details.DetailsFragment

import kotlinx.android.synthetic.main.movies_fragment.*


class MoviesFragment : Fragment(), OnMovieClickListener {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var moviesAdapter: MoviesViewAdapter
    lateinit var moviesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = MoviesViewModelFactory(DependencyInjection.networkProvider)
        moviesViewModel = ViewModelProvider(this, factory).get(MoviesViewModelImpl::class.java)
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeState()
        observesData()
        updateUI()
    }

    private fun updateUI() {
        activity!!.title = "Movies"
    }

    private fun observesData() {
        moviesViewModel.observeMovies(lifecycle ){
            moviesAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        moviesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        moviesAdapter = MoviesViewAdapter(this)
        moviesRecyclerView.adapter = moviesAdapter
    }

    private fun observeState() {
        moviesViewModel.getState().observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer

            when (it) {
                State.LOADING -> moviesProgress.visibility = View.VISIBLE
                State.LOADED -> moviesProgress.visibility = View.GONE
                State.ERROR -> {
                    moviesProgress.visibility = View.GONE
                    Toast.makeText(this.requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onMovieClicked(movie: Movie, adapterPosition: Int) {
        val detailsFragment = DetailsFragment.newInstance(movie)
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.container, detailsFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack("main").commit()
    }



}
