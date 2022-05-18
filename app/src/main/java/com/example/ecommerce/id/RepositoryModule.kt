package com.example.ecommerce.id

import com.example.ecommerce.data.articles.datasourse.ArticlesDataSourcesImp
import com.example.ecommerce.data.articles.repository.ArticlesRepository
import com.example.ecommerce.data.articles.repository.ArticlesRepositoryImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun gsonProvide(): Gson = Gson()

    @Singleton
    @Provides
    fun articlesRepositoryProvide(
        usersDataSources: ArticlesDataSourcesImp,
    ): ArticlesRepository = ArticlesRepositoryImp(usersDataSources )



}