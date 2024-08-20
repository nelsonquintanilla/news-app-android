package com.nelsonquintanilla.news.data.repositories

import com.nelsonquintanilla.news.data.local.ArticlesDatabase
import com.nelsonquintanilla.news.data.mapper.toArticle
import com.nelsonquintanilla.news.data.mapper.toArticleEntity
import com.nelsonquintanilla.news.data.remote.ArticlesApiService
import com.nelsonquintanilla.news.domain.model.Article
import com.nelsonquintanilla.news.domain.repository.ArticlesRepository
import com.nelsonquintanilla.news.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    dataBase: ArticlesDatabase,
    private val apiService: ArticlesApiService
): ArticlesRepository {

    private val dao = dataBase.articleEntityDao

    override suspend fun getAllArticles(): Flow<Resource<List<Article>>> {
        return flow {
            emit(Resource.Loading(true))
            val localArticles: List<Article> = dao.getAllArticles().map { it.toArticle() }
            emit(Resource.Success(localArticles))

            try {
                val remoteArticles = apiService.getAllNews().response.results.map { it.toArticleEntity() }
                dao.clearArticles()
                dao.insertArticles(remoteArticles)
                val updatedArticles = dao.getAllArticles().map { it.toArticle() }
                emit(Resource.Success(updatedArticles))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("An error occurred"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("An error occurred"))
            }
        }
    }
}