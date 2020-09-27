package com.ruthvikbr.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ruthvikbr.newsapp.R
import com.ruthvikbr.newsapp.db.ArticleDatabase
import com.ruthvikbr.newsapp.db.NewsRepository
import com.ruthvikbr.newsapp.ui.viewmodels.NewsViewModel
import com.ruthvikbr.newsapp.ui.viewmodels.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

     lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelFactory = NewsViewModelFactory(newsRepository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
        bottomNavigationView.setOnNavigationItemReselectedListener {
            //No Operation
        }
    }
}