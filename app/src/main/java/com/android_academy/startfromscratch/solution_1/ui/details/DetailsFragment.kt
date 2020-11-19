package com.android_academy.startfromscratch.solution_1.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android_academy.db.Movie
import com.android_academy.db.MovieModelConverter
import com.android_academy.startfromscratch.R
import com.android_academy.startfromscratch.solution_1.di.DependencyInjection
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.details_fragment.*

class DetailsFragment : Fragment() {

    private val executors = DependencyInjection.viewModelExecutor
    private val moviesNetworkProvider = DependencyInjection.networkProvider

    companion object {
        internal const val MOVIE_BUNDLE_KEY = "unique_movie_key"

        fun newInstance(movie: Movie): DetailsFragment {
            val args = Bundle()
            args.putInt(MOVIE_BUNDLE_KEY, movie.movieId)
            val detailsFragment = DetailsFragment()
            detailsFragment.arguments = args
            return detailsFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getInt(MOVIE_BUNDLE_KEY)
        movieId?.let(::loadMovie)
    }

    private fun loadMovie(movieId: Int) {
        executors.execute {
            val movies = moviesNetworkProvider.getMovies() ?: return@execute
            val convertNetworkMovieToModel = MovieModelConverter.convertNetworkMovieToModel(movies)
            val movie =
                convertNetworkMovieToModel.firstOrNull { it.movieId == movieId } ?: return@execute
            view?.post {
                setData(movie)
            }
        }
    }

    private fun setData(movie: Movie) {
        activity!!.title = movie.name
        detailsMovieNameText.text = movie.name
        detailsOverviewText.text = movie.overview
        detailsMovieRatingText.text = movie.voteAverage.toString()
        detailsMovieDateText.text = movie.releaseDate
        if (movie.imageUrl.isNotEmpty()) {
            Picasso.get()
                .load(movie.imageUrl)
                .into(detailsBgImage)
        }
    }
}