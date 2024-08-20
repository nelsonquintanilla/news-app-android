package com.nelsonquintanilla.news.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class JsonResponseDto(
    val response: ResponseDto
)