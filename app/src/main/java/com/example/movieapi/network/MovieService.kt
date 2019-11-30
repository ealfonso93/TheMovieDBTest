package com.example.movieapi.network

import androidx.lifecycle.LiveData
import com.example.movieapi.models.PopularShowResponse
import retrofit2.http.GET

interface MovieService {

    @GET("/tv/popular?language=en")
    fun fetchPopularShows(): LiveData<ApiResponse<PopularShowResponse>>
}