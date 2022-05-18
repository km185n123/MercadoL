package com.example.ecommerce.data.articles.datasourse

import com.example.ecommerce.data.articles.datasourse.apiservice.ArticlesApiServices
import com.example.ecommerce.data.articles.datasourse.apiservice.model.ArticlesResponse
import com.example.ecommerce.utils.ResultDataApi
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import kotlin.coroutines.resume

class ArticlesDataSourcesImp @Inject constructor(
    val articlesApiServices: ArticlesApiServices
    ) : ArticlesDataSources {

    override suspend fun getArticles(search:String): ResultDataApi<ArticlesResponse> =
        suspendCoroutine {
            val result =  articlesApiServices.getArticles(search)
            result.enqueue(object : Callback<ArticlesResponse>{
                override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>) {
                    when {
                        response.isSuccessful -> {
                            it.resume(ResultDataApi.Success(response.body()!!))
                        }
                        else -> it.resume(ResultDataApi.Failure(Throwable(response.errorBody().toString())))
                    }
                }
                override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                    it.resume(ResultDataApi.Failure(t))
                }
            })

        }

    override suspend fun getArticlesByCategory(Category:String): ResultDataApi<ArticlesResponse> =
        suspendCoroutine {
            val result =  articlesApiServices.getArticlesByCategory(Category)
            result.enqueue(object : Callback<ArticlesResponse>{
                override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>) {
                    when {
                        response.isSuccessful -> {
                            it.resume(ResultDataApi.Success(response.body()!!))
                        }
                        else -> it.resume(ResultDataApi.Failure(Throwable(response.errorBody().toString())))
                    }
                }
                override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                    it.resume(ResultDataApi.Failure(t))
                }
            })

        }

}