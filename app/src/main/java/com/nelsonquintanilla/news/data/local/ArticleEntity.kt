package com.nelsonquintanilla.news.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "sectionName")
    val sectionName: String,
    @ColumnInfo(name = "webPublicationDate")
    val webPublicationDate: String,
    @ColumnInfo(name = "webTitle")
    val webTitle: String,
    @ColumnInfo(name = "webUrl")
    val webUrl: String
)