package com.example.ecommerce.id

import com.example.ecommerce.data.articles.repository.ArticlesRepositoryImp
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesByCategoryUseCaseImp
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesByCatogoryUseCase
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesUseCase
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun getArticlesUseCaseProvider(usersRepository: ArticlesRepositoryImp): GetArticlesUseCase
            = GetArticlesUseCaseImp(usersRepository)

    @Provides
    fun getArticlesByCategoryUseCaseProvider(usersRepository: ArticlesRepositoryImp): GetArticlesByCatogoryUseCase
            = GetArticlesByCategoryUseCaseImp(usersRepository)



}