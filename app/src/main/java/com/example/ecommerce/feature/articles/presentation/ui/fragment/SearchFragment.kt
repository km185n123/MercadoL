package com.example.ecommerce.feature.articles.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.databinding.SearchFragmentBinding
import com.example.ecommerce.feature.articles.presentation.ui.adapter.SearchAdapter
import com.example.ecommerce.feature.articles.presentation.viewmodel.SearcherViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var _binding: SearchFragmentBinding
    private val binding get() = _binding
    private val searcherViewModel: SearcherViewModelImp by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        activity?.setTitle(R.string.app_name)
        searcherViewModel.articlesLiveData.observe(viewLifecycleOwner) {
              loadArticles(it)
        }
        searcherViewModel.showErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        }
        searcherViewModel.listIsEmptyLiveData.observe(viewLifecycleOwner) {
            if (it){
                view?.findNavController()?.navigate(R.id.messageFragment)
            }
        }
        return root
    }

    private fun loadArticles(list: List<Article>) {
        _binding.searchRecycler.layoutManager = LinearLayoutManager(activity)
        _binding.searchRecycler.adapter =list?.let { SearchAdapter(it) }
    }





}