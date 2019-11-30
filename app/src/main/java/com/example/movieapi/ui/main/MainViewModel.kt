package com.example.movieapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapi.models.Show
import com.example.movieapi.repository.MovieRepository
import javax.inject.Inject

class MainViewModel  @Inject
constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val showsListLiveData: LiveData<List<Show>>

    init {
        showsListLiveData = movieRepository.loadPopularShows()
    }
}
