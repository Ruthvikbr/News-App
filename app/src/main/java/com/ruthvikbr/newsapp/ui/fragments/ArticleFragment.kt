package com.ruthvikbr.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ruthvikbr.newsapp.R
import com.ruthvikbr.newsapp.models.Article
import com.ruthvikbr.newsapp.ui.NewsActivity
import com.ruthvikbr.newsapp.ui.viewmodels.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    private val args:ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        setupView(article)
    }

    private fun setupView(article: Article){
        Glide.with(this).load(article.urlToImage).into(ArticleImage)
        ArticleTitle.text = article.title
        ArticleDescription.text = article.description
    }

}