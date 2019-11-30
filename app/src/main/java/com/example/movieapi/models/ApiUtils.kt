package com.example.movieapi.models

import com.example.movieapi.BuildConfig

object ApiUtils {
    fun getPosterUrl(posterName: String) = BuildConfig.POST_HOST + posterName
}