package com.nelsonquintanilla.news.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleEntityDao {

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<ArticleEntity>

    @Query("DELETE FROM articles")
    suspend fun clearArticles()

    @Insert
    suspend fun insertArticles(articleEntityList: List<ArticleEntity>)
}