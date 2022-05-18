package com.example.ecommerce.id

import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesByCategoryUseCaseImp
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesUseCaseImp
import com.example.ecommerce.feature.articles.presentation.viewmodel.ArticlesViewModel
import com.example.ecommerce.feature.articles.presentation.viewmodel.ArticlesViewModelImp
import com.example.ecommerce.feature.articles.presentation.viewmodel.SearcherViewModel
import com.example.ecommerce.feature.articles.presentation.viewmodel.SearcherViewModelImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object ViewModelModule {

    @Provides
    fun usersViewModelImProvide(
         getArticlesUseCase: GetArticlesUseCaseImp
    ): SearcherViewModel = SearcherViewModelImp(getArticlesUseCase)

    @Provides
    fun articlesViewModelImpProvide(
        getArticlesByCategoryUseCase: GetArticlesByCategoryUseCaseImp
    ): ArticlesViewModel = ArticlesViewModelImp(getArticlesByCategoryUseCase)


}