package com.example.movieapi.models.net

data class ErrorEnvelope(
    val status_code: Int,
    val status_message: String,
    val success: Boolean
)