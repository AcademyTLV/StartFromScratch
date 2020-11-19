package com.android_academy.startfromscratch.exercise_1.db

import com.android_academy.startfromscratch.exercise_1.network.MoviesListResult
import com.android_academy.startfromscratch.exercise_1.network.NetworkingConstants.POSTER_BASE_URL


data class Movie(
    val movieId: Int,
    val name: String,
    val imageUrl: String,
    val overview: String?,
    val releaseDate: String,
    val voteAverage: Double
)

object MovieModelConverter {

    //TODO Exercise #1 after moving MoviesListResult to network module change here import as well of MoviesListResult
    fun convertNetworkMovieToModel(model: MoviesListResult): List<Movie> {
        return model.results.map {
            Movie(
                movieId = it.id,
                name = it.title,
                //TODO Exercise #1 after moving MoviesListResult to network module change import of POSTER_BASE_URL as well
                imageUrl = "${POSTER_BASE_URL}${it.posterPath}",
                overview = it.overview,
                voteAverage = it.voteAverage,
                releaseDate = it.release_date
            )
        }
    }
}