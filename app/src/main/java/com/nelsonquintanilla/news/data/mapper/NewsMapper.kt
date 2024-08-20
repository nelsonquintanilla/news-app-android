package com.nelsonquintanilla.news.data.mapper

import com.nelsonquintanilla.news.data.local.ArticleEntity
import com.nelsonquintanilla.news.data.remote.dto.ArticleDto
import com.nelsonquintanilla.news.domain.model.Article

fun ArticleDto.toArticleEntity() = ArticleEntity(
    sectionName = sectionName,
    webPublicationDate = webPublicationDate,
    webTitle = webTitle,
    webUrl = webUrl
)

fun ArticleEntity.toArticle() = Article(
    sectionName = sectionName,
    webPublicationDate = webPublicationDate,
    webTitle = webTitle,
    webUrl = webUrl
)