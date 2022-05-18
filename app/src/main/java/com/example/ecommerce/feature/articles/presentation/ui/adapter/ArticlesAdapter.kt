package com.example.ecommerce.feature.articles.presentation.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerce.R
import com.example.ecommerce.data.articles.datasourse.apiservice.model.Article
import com.example.ecommerce.databinding.ItemArticleBinding
import com.example.ecommerce.feature.articles.presentation.viewmodel.ItemViewModel

class ArticlesAdapter(
    private var list: List<Article>,
) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(){

    private lateinit var _itemBinding: ItemArticleBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _itemBinding = ItemArticleBinding.inflate(layoutInflater,parent,false)
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

    class ViewHolder(private var tv: ItemArticleBinding, var list: List<Article>) : RecyclerView.ViewHolder(tv.root) {
        fun bind(item: Article){
            tv.title.text = item.title
            tv.price.text = item.price.toString()
            Glide.with(tv.root.context).load(item.thumbnail).into(tv.image)
            tv.root.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("title",item.title)
                bundle.putString("image",item.thumbnail)
                bundle.putString("price",item.price.toString())
                tv.root.findNavController().navigate(R.id.action_articlesFragment_to_articleActivity,bundle)
            }
        }
    }
}