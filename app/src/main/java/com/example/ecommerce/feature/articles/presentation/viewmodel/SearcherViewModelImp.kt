package com.example.ecommerce.feature.articles.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.feature.articles.domain.usecase.GetArticlesUseCase
import com.example.ecommerce.utils.ResultDataApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import io.reactivex.functions.Consumer
@HiltViewModel
class SearcherViewModelImp @Inject constructor(
    val getArticlesUseCase: GetArticlesUseCase,

    ):ViewModel(), SearcherViewModel{

    private val progressDialog: MutableLiveData<Boolean> = MutableLiveData()
    val progressDialogLiveData: LiveData<Boolean> = progressDialog

    private val _error: MutableLiveData<String> = MutableLiveData()
    val showErrorLiveData: LiveData<String> = _error

    private val _emptyValidation: MutableLiveData<Int> = MutableLiveData()
    val emptyValidationLiveData: LiveData<Int> = _emptyValidation

    private val _listIsEmpty: MutableLiveData<Boolean> = MutableLiveData()
    val listIsEmptyLiveData: LiveData<Boolean> = _listIsEmpty

    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
    val articlesLiveData: LiveData<List<Article>> = _articles

    fun cleanList(){
        _articles.value = arrayListOf()
    }

    fun fetchArticle(search: String?) {
        progressDialog.postValue(true)
         viewModelScope.launch {
                if (search != null && search.isNotEmpty()) {
                    getArticlesUseCase.invoke(search).subscribe(Consumer {
                        progressDialog.postValue(false)
                        handleResponse(it)
                    })
                }else{
                    _emptyValidation.postValue(View.VISIBLE)
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
            _listIsEmpty.value = true

        }else{
            _listIsEmpty.value = false
            _articles.postValue(value)
        }
        progressDialog.postValue(false)

    }
}