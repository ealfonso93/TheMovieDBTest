package com.example.movieapi.ui.main

import androidx.lifecycle.ViewModel
import com.example.movieapi.repository.MovieRepository
import javax.inject.Inject

class MainViewModel  @Inject
constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {
// TODO: Implement the ViewModel
}
