package com.ruthvikbr.newsapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.ruthvikbr.newsapp.db.NewsRepository
import com.ruthvikbr.newsapp.models.NewsResponse
import com.ruthvikbr.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    val breakingNews :MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("us")
    }

     private fun getBreakingNews(countryCode:String){
         viewModelScope.launch {
             breakingNews.postValue(Resource.Loading())
             val response =
                 newsRepository.getBreakingNews(countryCode,breakingNewsPage)
             breakingNews.postValue(handleBreakingNewsResponse(response))

         }
     }

    private fun handleBreakingNewsResponse(
        response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful){
            response.body()?.let {
                return  Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

}