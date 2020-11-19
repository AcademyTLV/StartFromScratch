package com.android_academy.startfromscratch.exercise_1.network

import com.google.gson.annotations.SerializedName

//TODO Exercise #1 move it to separate file and change import in MockMovieService and MockNetworkDependency
data class MoviesListResult (

    @SerializedName("page") val page : Int,
    @SerializedName("total_results") val totalResults : Int,
    @SerializedName("total_pages") val totalPages : Int,
    @SerializedName("results") val results : List<MovieResult>
)

//TODO Exercise #1 move it to separate file and change import in MockMovieService and MockNetworkDependency
data class MovieResult (

    @SerializedName("vote_count") val voteCount : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("video") val video : Boolean,
    @SerializedName("vote_average") val voteAverage : Double,
    @SerializedName("title") val title : String,
    @SerializedName("popularity") val popularity : Double,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("original_language") val original_language : String,
    @SerializedName("original_title") val originalTitle : String,
    @SerializedName("genre_ids") val genre_ids : List<Int>,
    @SerializedName("backdrop_path") val backdropPath : String,
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("overview") val overview : String,
    @SerializedName("release_date") val release_date : String
)
