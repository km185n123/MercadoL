package com.example.ecommerce

import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesUseCase
import com.example.ecommerce.feature.articles.presentation.viewmodel.SearcherViewModelImp
import com.example.ecommerce.utils.ResultDataApi
import com.example.ecommerce.utils.TestCoroutineRule
import io.reactivex.Single
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearcherViewModelImpTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: SearcherViewModelImp

    @Mock
    private lateinit var getArticlesUseCase: GetArticlesUseCase

    lateinit var articles : ArrayList<Article>
    @Before
    fun setUp(){
        viewModel = SearcherViewModelImp(getArticlesUseCase)

        articles  = arrayListOf()
        val article1 = Article("1","phone")
        val article2 = Article("2","car")
        articles.add(article1)
        articles.add(article2)

    }

    @Test
    fun fetchArticles(){
        runBlocking {
            // mock
            val textKey = "car"
            val filter = articles.filter { article -> article.title.contains(textKey) }
            val resultDataApi = ResultDataApi.Success(filter)
            val result:Single<ResultDataApi<List<Article>>> = Single.just(resultDataApi)
            Mockito.`when`(getArticlesUseCase.invoke(textKey)).thenReturn(result)
            // call
            viewModel.fetchArticle(textKey)
            // test
            val actual = viewModel.articlesLiveData.value?.size
            val expected = 1
            Assert.assertEquals(expected,actual)

        }
    }

    @Test
    fun fetchArticlesIsEmpty(){
        runBlocking {
            // mock
            val textKey = "?"
            val filter = articles.filter { article -> article.title.contains(textKey) }
            val resultDataApi = ResultDataApi.Success(filter)
            val result:Single<ResultDataApi<List<Article>>> = Single.just(resultDataApi)

            Mockito.`when`(getArticlesUseCase.invoke(textKey)).thenReturn(result)
            // call
            viewModel.fetchArticle(textKey)
            // test
            val actual = viewModel.articlesLiveData.value?.size
            val expected = 0
            Assert.assertEquals(expected,actual)

        }
    }

    @Test
    fun theSearchWordIsEmpty(){
        runBlocking {
            // mock
            val textKey = ""
            // call
            viewModel.fetchArticle(textKey)
            // test
            val actual = viewModel.emptyValidationLiveData.value
            val expected = View.VISIBLE
            Assert.assertEquals(expected,actual)

        }
    }


    @Test
    fun fetchArticlesIsError(){
        runBlocking {
            // mock
            val resultDataApi = ResultDataApi.Failure<Throwable>(Throwable("Error"))
            val result:Single<ResultDataApi<*>> = Single.just(resultDataApi)
            val textKey = "mac"
            Mockito.`when`(getArticlesUseCase.invoke(textKey)).then { result }
            // call
            viewModel.fetchArticle(textKey)
            // test
            val actual = viewModel.showErrorLiveData.value
            val expected = "Error"
            Assert.assertEquals(expected,actual)

        }
    }





}