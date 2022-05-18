package com.example.ecommerce.feature.articles.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.databinding.FragmentArticlesBinding
import com.example.ecommerce.feature.articles.presentation.ui.adapter.ArticlesAdapter
import com.example.ecommerce.feature.articles.presentation.viewmodel.ArticlesViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment : Fragment() {
    private lateinit var _binding: FragmentArticlesBinding
    private val binding get() = _binding
    private val articlesViewModel: ArticlesViewModelImp by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticlesBinding.inflate(inflater, container,false)
        val root: View = binding.root
        val categoryID = arguments?.getString("category_id")
        articlesViewModel.fetchArticle(category = categoryID)
        articlesViewModel.articlesLiveData.observe(viewLifecycleOwner){
            loadArticles(it)
        }

        return root
    }

    private fun loadArticles(list: List<Article>) {
        _binding.articlesRecycler.layoutManager = LinearLayoutManager(activity)
        _binding.articlesRecycler.adapter =list?.let { ArticlesAdapter(it) }
    }


}