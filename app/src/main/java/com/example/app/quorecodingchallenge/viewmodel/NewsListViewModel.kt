package com.example.app.quorecodingchallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.quorecodingchallenge.datasource.remote.API_KEY
import com.example.app.quorecodingchallenge.datasource.remote.NewsApiService
import com.example.app.quorecodingchallenge.model.news.NewsApiResponse

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsListViewModel : ViewModel() {
    val newsList = MutableLiveData<NewsApiResponse>()
    init {
        NewsApiService
            .getNewsApiService()
            .getTopHeadlines("us", API_KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { result -> newsList.postValue(result) }
            .subscribe()
    }
}