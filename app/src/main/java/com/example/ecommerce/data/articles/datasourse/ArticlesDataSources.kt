package com.example.ecommerce.data.articles.datasourse

import com.example.ecommerce.data.articles.datasourse.apiservice.model.ArticlesResponse
import com.example.ecommerce.utils.ResultDataApi

sealed interface ArticlesDataSources{
    suspend fun getArticles(search:String) : ResultDataApi<ArticlesResponse>
    suspend fun getArticlesByCategory(Category:String) : ResultDataApi<ArticlesResponse>
}