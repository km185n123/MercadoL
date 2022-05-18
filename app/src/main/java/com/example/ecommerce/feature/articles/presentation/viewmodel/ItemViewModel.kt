package com.example.ecommerce.feature.articles.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article

class ItemViewModel: ViewModel() {
    var article: MutableLiveData<Article> = MutableLiveData()
}
