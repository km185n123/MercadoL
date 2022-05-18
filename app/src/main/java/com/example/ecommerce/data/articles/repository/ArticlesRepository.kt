package com.example.ecommerce.data.articles.repository

import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.utils.ResultDataApi

interface ArticlesRepository {
     suspend fun getArticles(search: String): ResultDataApi<List<Article>>
     suspend fun getArticlesByCategory(category: String): ResultDataApi<List<Article>>
}