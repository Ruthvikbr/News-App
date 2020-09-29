package com.ruthvikbr.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ruthvikbr.newsapp.R
import com.ruthvikbr.newsapp.models.Article
import com.ruthvikbr.newsapp.ui.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_article.*

@AndroidEntryPoint
class ArticleFragment : Fragment(R.layout.fragment_article) {
    private val viewModel: NewsViewModel by viewModels()
    private val args:ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = args.article
        setupView(article)

        fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article saved",Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun setupView(article: Article){
        Glide.with(this).load(article.urlToImage).into(ArticleImage)
        ArticleTitle.text = article.title
        ArticleDescription.text = article.description
    }

}