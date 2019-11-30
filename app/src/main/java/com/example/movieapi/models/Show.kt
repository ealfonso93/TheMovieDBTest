package com.example.movieapi.models

data class Show (
    var original_name: String,
    var genre_ids: ArrayList<Int> = ArrayList(),
    var name: String,
    var popularity: Float,
    var originCountry: ArrayList<String> = ArrayList(),
    var vote_count: Int,
    var first_air_date: String,
    var backdrop_path: String,
    var original_language: String,
    var id: Int,
    var vote_average: Float,
    var overview: String,
    var poster_path: String
)