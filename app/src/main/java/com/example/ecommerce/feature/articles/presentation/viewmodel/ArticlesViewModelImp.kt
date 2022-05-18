package com.example.ecommerce.feature.articles.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesByCatogoryUseCase
import com.example.ecommerce.utils.ResultDataApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import io.reactivex.functions.Consumer
@HiltViewModel
class ArticlesViewModelImp @Inject constructor(
    val getArticlesByCategoryUseCase: GetArticlesByCatogoryUseCase,

    ):ViewModel(), ArticlesViewModel{

    private val progressDialog: MutableLiveData<Boolean> = MutableLiveData()
    val progressDialogLiveData: LiveData<Boolean> = progressDialog

    private val _error: MutableLiveData<String> = MutableLiveData()
    val showErrorLiveData: LiveData<String> = _error

    private val _emptyValidation: MutableLiveData<Int> = MutableLiveData()
    val emptyValidationLiveData: LiveData<Int> = _emptyValidation

    private val _listIsEmpty: MutableLiveData<Int> = MutableLiveData()
    val listIsEmptyLiveData: LiveData<Int> = _listIsEmpty

    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
    val articlesLiveData: LiveData<List<Article>> = _articles

    fun fetchArticle(category: String?) {
        progressDialog.postValue(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                if (category != null) {
                    getArticlesByCategoryUseCase.invoke(category).subscribe(Consumer {
                        progressDialog.postValue(false)
                        handleResponse(it)
                    })
                }
            }
        }
    }

    override fun handleResponse(it: ResultDataApi<List<Article>>) {
        when (it) {
            is ResultDataApi.Success -> setData(it.value)
            is ResultDataApi.Failure -> _error.postValue(it.throwable.message)
        }
    }

    override fun setData(value: List<Article>) {
        if (value.isEmpty()){
            _listIsEmpty.postValue(View.VISIBLE)
            _articles.postValue(value)
        }else{
           _listIsEmpty.postValue(View.INVISIBLE)
            _articles.postValue(value)
        }
        progressDialog.postValue(false)

    }
}