package com.example.movieapi.network

import com.example.movieapi.utils.LiveDataTestHelper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class MovieServiceTest: ApiTestHelper<MovieService>() {

    private lateinit var service: MovieService

    @Before
    fun startService() {
        service = createService(MovieService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun fetchPopularShowsTest() {
        enqueueResponse("/popular_shows.json")
        val response = LiveDataTestHelper.getValue(service.fetchPopularShows())
        assertEquals(response.body?.results?.get(0)?.id, 82856)
        assertEquals(response.body?.total_results, 10000)
        assertEquals(response.body?.total_pages, 500)
    }
}