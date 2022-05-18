package com.example.ecommerce.feature.articles.presentation.viewmodel

import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.utils.ResultDataApi

interface SearcherViewModel {
    fun handleResponse(it: ResultDataApi<List<Article>>)
    fun setData(value: List<Article>)

}
