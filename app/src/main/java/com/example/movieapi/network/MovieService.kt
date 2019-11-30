package com.example.movieapi.network

import androidx.lifecycle.LiveData
import com.example.movieapi.models.PopularShowResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("tv/popular?language=en-US")
    fun fetchPopularShows(@Query("page") page: Int): LiveData<ApiResponse<PopularShowResponse>>
}