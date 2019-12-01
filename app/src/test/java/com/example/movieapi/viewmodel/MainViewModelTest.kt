package com.example.movieapi.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.movieapi.models.PopularShowResponse
import com.example.movieapi.models.Resource
import com.example.movieapi.models.Show
import com.example.movieapi.network.ApiResponse
import com.example.movieapi.network.MovieService
import com.example.movieapi.repository.MovieRepository
import com.example.movieapi.ui.main.MainViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    private lateinit var movieRepository: MovieRepository

    private val movieService = mock<MovieService>()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        movieRepository = MovieRepository(movieService)
        viewModel = MainViewModel(movieRepository)
    }

    @Test
    fun loadPopularShows() {
        val mockResponse = PopularShowResponse(1, emptyList(), 288, 100)
        val call = successfulCall(mockResponse)
        whenever(movieService.fetchPopularShows(1)).thenReturn(call)

        val data = viewModel.showsListLiveData
        val observer = mock<Observer<Resource<List<Show>>>>()
        data.observeForever(observer)

        viewModel.loadShowsPage(1)
        verify(movieService).fetchPopularShows(1)
        verifyNoMoreInteractions(movieService)

        verify(observer).onChanged(
            Resource.success(viewModel.getShowListValues()!!.data, false)
        )

    }

    fun <T: Any> successfulCall(data: T): LiveData<ApiResponse<T>> {
        val success = Response.success(data)
        return MutableLiveData<ApiResponse<T>>().apply {
            value = ApiResponse(response = success)
        }  as LiveData<ApiResponse<T>>
    }
}