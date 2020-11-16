package com.android_academy.network

object NetworkingConstants  {
    const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

    const val BASE_URL = "http://api.themoviedb.org"

    /* base search image url */
    val BASE_API_URL = "$BASE_URL/3/"
    private const val POPULAR = "movie/popular"

    /* api key */
    const val apiKey = "24e7d4abbb0c127a1f8962a912bf34cf"
    private const val keyQuery = "?api_key=$apiKey&"

    const val DISCOVER_QUERY_PATH = keyQuery
}