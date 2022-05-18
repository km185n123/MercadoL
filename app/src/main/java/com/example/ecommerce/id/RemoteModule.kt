package com.example.ecommerce.id

import com.example.ecommerce.BuildConfig
import com.example.ecommerce.data.articles.datasourse.ArticlesDataSources
import com.example.ecommerce.data.articles.datasourse.ArticlesDataSourcesImp
import com.example.ecommerce.data.articles.datasourse.apiservice.ArticlesApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    @Provides
    fun httpLoggingInterceptorProvide(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun clientHttpProvide(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient
            = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun retrofitProvide(okHttpClient: OkHttpClient): Retrofit
            = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun usersApiServicesProvide(retrofit: Retrofit): ArticlesApiServices
            = retrofit.create(ArticlesApiServices::class.java)

    @Singleton
    @Provides
    fun articlesDataSourceProvide(articlesApiServices: ArticlesApiServices): ArticlesDataSources
            = ArticlesDataSourcesImp(articlesApiServices)



}