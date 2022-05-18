package com.example.ecommerce.feature.articles.domain.usecase

import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.data.articles.repository.ArticlesRepository
import com.example.ecommerce.utils.ResultDataApi
import javax.inject.Inject
import io.reactivex.Single

class GetArticlesByCategoryUseCaseImp @Inject constructor(
    val usersRepository: ArticlesRepository
): GetArticlesByCatogoryUseCase {
    override suspend fun invoke(search: String): Single<ResultDataApi<List<Article>>> {
        return  when (val result = usersRepository.getArticlesByCategory(search)){
            is ResultDataApi.Success<*> -> Single.just(result)
            is ResultDataApi.Failure<*> -> Single.just(result)
        }
    }


}