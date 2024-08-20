package com.nelsonquintanilla.news.data.remote

import com.nelsonquintanilla.news.data.remote.dto.JsonResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApiService {

    @GET("search")
    suspend fun getAllNews(
        @Query("page-size") pageSize: String = PAGE_SIZE,
        @Query("api-key") apiKey: String = API_KEY
    ): JsonResponseDto

    companion object {
        const val BASE_URL = "https://content.guardianapis.com"
        const val PAGE_SIZE = "50"
        const val API_KEY = "f360f7e8-033e-4a24-b25c-81bab8512d58"
    }
}