package com.example.ecommerce.feature.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.ActivityMainBinding
import com.example.ecommerce.feature.articles.presentation.viewmodel.SearcherViewModelImp
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val searcherViewModel: SearcherViewModelImp by viewModels()
    lateinit var  navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayShowTitleEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setIcon(R.mipmap.ic_launcher);
        setContentView(binding.root)
         navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.searchFragment
        ))

        setupActionBarWithNavController(navController, appBarConfiguration)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()

            return true
        }
        return true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val menuItem = menu?.findItem(R.id.action_search)
        val searchView: SearchView = menuItem?.actionView as SearchView
        searchView.queryHint = "Buscar en Mercado Libre"

        searchView.setOnSearchClickListener {
            navController.navigate(R.id.searchFragment)

        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                    navController.navigate(R.id.searchFragment)
                    searcherViewModel.fetchArticle(newText)
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }




}