package com.example.ecommerce.data.articles.repository

import com.example.ecommerce.data.articles.datasourse.ArticlesDataSources
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.data.articles.datasourse.apiservice.model.ArticlesResponse
import com.example.ecommerce.utils.ResultDataApi
import javax.inject.Inject

class ArticlesRepositoryImp @Inject constructor(
    val usersDataSources: ArticlesDataSources,
) : ArticlesRepository {

    override suspend fun getArticles(search: String): ResultDataApi<List<Article>> {
        return when (val result = usersDataSources.getArticles(search)) {
                    is ResultDataApi.Success<*> -> {
                        val response = result.value as ArticlesResponse
                        ResultDataApi.Success(response.articles)
                    }
                    is ResultDataApi.Failure<*> -> ResultDataApi.Failure(result.throwable)
                }
        }

    override suspend fun getArticlesByCategory(category: String): ResultDataApi<List<Article>> {
        return when (val result = usersDataSources.getArticlesByCategory(category)) {
            is ResultDataApi.Success<*> -> {
                val response = result.value as ArticlesResponse
                ResultDataApi.Success(response.articles)
            }
            is ResultDataApi.Failure<*> -> ResultDataApi.Failure(result.throwable)
        }
    }


}


