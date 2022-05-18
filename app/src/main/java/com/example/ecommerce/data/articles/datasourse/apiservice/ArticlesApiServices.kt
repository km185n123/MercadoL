package com.example.ecommerce.data.articles.datasourse.apiservice

import com.example.ecommerce.data.articles.datasourse.apiservice.model.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApiServices {
    @GET(ServicesEndPoints.USERS+"/MCO/search")
    fun getArticles(
        @Query("q") search:String
    ): Call<ArticlesResponse>

    @GET(ServicesEndPoints.USERS+"/MCO/search")
    fun getArticlesByCategory(
        @Query("category") category:String
    ): Call<ArticlesResponse>
}