package com.example.ecommerce.feature.articles.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ecommerce.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        val title = intent.extras?.getString("title")
        val image = intent.extras?.getString("image")
        val price = intent.extras?.getString("price")

        _binding.title.text = title
        Glide.with(this).load(image).into(_binding.image)
        _binding.price.text = price
    }
}