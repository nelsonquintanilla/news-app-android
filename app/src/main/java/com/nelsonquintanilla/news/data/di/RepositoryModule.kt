package com.nelsonquintanilla.news.data.di

import com.nelsonquintanilla.news.data.repositories.ArticlesRepositoryImpl
import com.nelsonquintanilla.news.domain.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun providesArticlesRepository(articlesRepositoryImpl: ArticlesRepositoryImpl): ArticlesRepository
}