package com.poc.network.home.data.api

import com.poc.network.home.data.model.ListMoviesDTO
import com.poc.network.home.data.model.MovieDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface HomeAPI {

    @GET(MOVIE_TOP)
    suspend  fun getMoviesTOP(@Query("api_key") api_key: String, @Query("page") page: Int): Response<ListMoviesDTO>

    @GET(MOVIES_POPULAR)
    suspend fun getMoviesPopular(@Query("api_key") api_key: String, @Query("page") page: Int): Response<ListMoviesDTO>

    @GET(SEARCH_MOVIE)
    suspend  fun getMoviesBySearchName(@Query("query") name: String, @Query("api_key") api_key: String, @Query("page") page: Int, @Query("language") language: String = "pt-br"): Response<ListMoviesDTO>

    @GET(DETAIL_MOVIE)
    suspend  fun getDetailsMovie(@Query("api_key") api_key: String, @Query("movie_id") movie_id: Int, @Query("language") language: String = "pt-br"): Response<MovieDTO>

    companion object {
        private const val MOVIES_POPULAR = "movie/popular"
        private const val MOVIE_TOP = "movie/top_rated"
        private const val SEARCH_MOVIE ="search/movie"
        private const val DETAIL_MOVIE = "movie/"
        const val TOKEN_API = "141671642cb27ab3e1f4f58cf119fd6e"

    }
}