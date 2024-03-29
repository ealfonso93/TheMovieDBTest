package com.example.movieapi.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movieapi.models.PopularShowResponse
import com.example.movieapi.models.Resource
import com.example.movieapi.models.Show
import com.example.movieapi.network.ApiResponse
import com.example.movieapi.network.MovieService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class MovieRepositoryTest {
    private lateinit var repository: MovieRepository
    private val movieService = mock<MovieService>()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        repository = MovieRepository(movieService)
    }

    @Test
    fun loadPopularTvShows() {
        val mockResponse = PopularShowResponse(1, emptyList(), 288, 100)
        val call = successfulCall(mockResponse)
        whenever(movieService.fetchPopularShows(1)).thenReturn(call)

        val resp = repository.loadPopularShows(1)
        val observer = mock<Observer<Resource<List<Show>>>>()
        resp.observeForever(observer)
        val results = MutableLiveData<List<Show>>()

        verify(movieService).fetchPopularShows(1)

        results.postValue(mockResponse.results)
        verify(observer).onChanged(Resource.success(mockResponse.results, false))
        verify(movieService).fetchPopularShows(1)
    }

    fun <T: Any> successfulCall(data: T): LiveData<ApiResponse<T>> {
        val success = Response.success(data)
        return MutableLiveData<ApiResponse<T>>().apply {
            value = ApiResponse(response = success)
        }  as LiveData<ApiResponse<T>>
    }
}