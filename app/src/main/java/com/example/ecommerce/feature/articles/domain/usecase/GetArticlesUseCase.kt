package com.example.ecommerce.feature.articles.domain.usecase

import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.utils.ResultDataApi
import io.reactivex.Single

interface GetArticlesUseCase {
    suspend fun invoke(search: String): Single<ResultDataApi<List<Article>>>
}