package com.example.news.ui.home

import androidx.lifecycle.ViewModel
import com.example.news.db.model.Article
import com.example.news.repository.Listing
import com.example.news.repository.MainRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(var repository: MainRepository) : ViewModel() {

    var repoResult: Listing<Article> = repository.getTopHeadlines()

    val posts = repoResult.pagedList
    val networkState = repoResult.networkState
    val refreshState = repoResult.refreshState

    fun refresh() {
        repoResult.refresh.invoke()
    }

    fun retry() {
        repoResult.retry.invoke()
    }

}