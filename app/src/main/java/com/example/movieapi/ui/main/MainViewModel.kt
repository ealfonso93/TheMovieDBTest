package com.example.movieapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.movieapi.models.Show
import com.example.movieapi.repository.MovieRepository
import com.example.movieapi.utils.EmptyLiveData
import javax.inject.Inject

class MainViewModel  @Inject
constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val showsListLiveData: LiveData<List<Show>>
    private var currentPageLiveData: MutableLiveData<Int> = MutableLiveData()

    init {
        showsListLiveData = Transformations.switchMap(currentPageLiveData) {
            currentPageLiveData.value?.let { movieRepository.loadPopularShows(it) }
        } ?: EmptyLiveData.create()
    }

    fun loadShowsPage(page: Int) {
        currentPageLiveData.postValue(page)
    }
}
