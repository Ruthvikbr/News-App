package com.ruthvikbr.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ruthvikbr.newsapp.R
import com.ruthvikbr.newsapp.ui.NewsActivity
import com.ruthvikbr.newsapp.ui.viewmodels.NewsViewModel

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}