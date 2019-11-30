package com.example.movieapi.models

data class PopularShowResponse (
    val page: Int,
    val results: List<Show>,
    val total_results: Int,
    val total_pages: Int
)