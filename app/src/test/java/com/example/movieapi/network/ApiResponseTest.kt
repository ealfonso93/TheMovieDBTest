package com.example.movieapi.network

import com.example.movieapi.network.ApiResponse
import retrofit2.Response
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.Exception

@RunWith(JUnit4::class)
class ApiResponseTest {
    @Test
    fun requestWentWrong() {
        val exception = Exception("any")
        val response = ApiResponse<String>(exception)
        assertFalse(response.isSuccessful)
        assertNull(response.body)
        assertEquals(response.code, 500)
        assertEquals(response.message, "any")
    }

    @Test
    fun requestWentOk() {
        val response = ApiResponse(Response.success("any"))
        assertTrue(response.isSuccessful)
        assertEquals(response.code, 200)
        assertEquals(response.body, "any")
        assertNull(response.message)
    }
}