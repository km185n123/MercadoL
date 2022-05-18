package com.example.ecommerce.feature.articles.presentation.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.databinding.ItemSearchBinding
import com.example.ecommerce.feature.articles.presentation.viewmodel.ItemViewModel


class SearchAdapter(
    private var list: List<Article>,
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){

    private lateinit var _itemBinding: ItemSearchBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _itemBinding = ItemSearchBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(_itemBinding,list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = ItemViewModel()
        itemViewModel.article.value = list[position]
        holder.bind(list[position])
    }

    class ViewHolder(private var tv: ItemSearchBinding, var list: List<Article>) : RecyclerView.ViewHolder(tv.root) {
        fun bind(item: Article){
            tv.txtName.text = item.title
            tv.root.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("category_id",item.categoryID)
                val navOptions = NavOptions.Builder().setPopUpTo(com.example.ecommerce.R.id.searchFragment, true).build()
                tv.root.findNavController().navigate(com.example.ecommerce.R.id.action_searchFragment_to_articlesFragment,bundle,navOptions)
            }

        }
    }
}