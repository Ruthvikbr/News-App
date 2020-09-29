package com.ruthvikbr.newsapp.db

import com.ruthvikbr.newsapp.api.RetrofitInstance
import com.ruthvikbr.newsapp.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val articleDao: ArticleDao
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearchResults(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun insert(article: Article) = articleDao.insertArticle(article)

    fun getSavedNews() = articleDao.getAllArticles()

    suspend fun delete(article: Article) = articleDao.deleteArticle(article)

}