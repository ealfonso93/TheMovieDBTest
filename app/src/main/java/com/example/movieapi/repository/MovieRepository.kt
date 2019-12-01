package com.example.movieapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.movieapi.models.PopularShowResponse
import com.example.movieapi.models.Resource
import com.example.movieapi.models.Show
import com.example.movieapi.network.MovieService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject
constructor(val movieService: MovieService): Repository {

    private val result: MediatorLiveData<Resource<List<Show>>> = MediatorLiveData()

    fun loadPopularShows(page: Int): LiveData<Resource<List<Show>>> {
        val popularShowsResponse = movieService.fetchPopularShows(page)
        result.addSource(popularShowsResponse) {response ->
            result.postValue(Resource.loading(null))
            when (response.isSuccessful) {
                true ->
                    response.body?.let {
                        result.postValue(Resource.success(it.results, isLastPage(response.body)))
                    }
                false ->
                    response.message?.let {
                        result.postValue(Resource.error(it,null))
                    }
            }
        }
        return result
    }

    private fun isLastPage(response: PopularShowResponse): Boolean {
        return response.page > response.total_pages
    }
}