package com.poc.network.home.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDTO(
    @SerializedName("adult")
    @Expose
    val adult: Boolean,

    @SerializedName("backdrop_path")
    @Expose
    val backdrop_path: String,

    @SerializedName("genre_ids")
    @Expose
    val genreIds: List<Integer>,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String,

    @SerializedName("overview")
    @Expose
    val overview: String,

    @SerializedName("popularity")
    @Expose
    val popularity: String,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String,

    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("video")
    @Expose
    val video: Boolean,
    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double,

    @SerializedName("vote_count")
    @Expose
    val voteCount: Int
) : Parcelable


@Parcelize
data class ListMoviesDTO(
    @SerializedName("results")
    @Expose
    val listMovies: List<MovieDTO>
): Parcelable
