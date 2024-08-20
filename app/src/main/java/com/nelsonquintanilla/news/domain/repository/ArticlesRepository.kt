package com.nelsonquintanilla.news.domain.repository

import com.nelsonquintanilla.news.domain.model.Article
import com.nelsonquintanilla.news.util.Resource
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    suspend fun getAllArticles(): Flow<Resource<List<Article>>>
}