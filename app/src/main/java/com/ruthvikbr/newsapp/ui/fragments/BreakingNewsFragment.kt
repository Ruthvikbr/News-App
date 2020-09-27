package com.ruthvikbr.newsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruthvikbr.newsapp.R
import com.ruthvikbr.newsapp.adapters.NewsAdapter
import com.ruthvikbr.newsapp.ui.NewsActivity
import com.ruthvikbr.newsapp.ui.viewmodels.NewsViewModel
import com.ruthvikbr.newsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    private val TAG = "BREAKING NEWS FRAGMENT"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner,{response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }

                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {message ->
                        Log.e(TAG,message)
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }

            }
        })

    }
    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}