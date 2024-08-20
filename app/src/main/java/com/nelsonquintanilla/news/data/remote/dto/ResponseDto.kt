package com.nelsonquintanilla.news.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String,
    val results: List<ArticleDto>
)