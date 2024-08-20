package com.nelsonquintanilla.news.ui.articles

import com.nelsonquintanilla.news.domain.model.Article

data class ArticlesUiState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false
)