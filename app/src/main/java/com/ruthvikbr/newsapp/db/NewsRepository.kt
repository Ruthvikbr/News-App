package com.ruthvikbr.newsapp.db

import com.ruthvikbr.newsapp.api.RetrofitInstance

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun getSearchResults(searchQuery:String, pageNumber:Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)
}