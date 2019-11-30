package com.example.movieapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.movieapi.models.Show
import com.example.movieapi.network.MovieService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject
constructor(val movieService: MovieService): Repository {

    private val result: MediatorLiveData<List<Show>> = MediatorLiveData()

    fun loadPopularShows(page: Int): LiveData<List<Show>> {
        val popularShowsResponse = movieService.fetchPopularShows(page)
        result.addSource(popularShowsResponse) {response ->
            when (response.isSuccessful) {
                true ->
                    response.body?.let {
                        result.value = it.results
                    }
                //false ->
                    //TODO what if it goes wrong
            }
        }
        return result
    }
}