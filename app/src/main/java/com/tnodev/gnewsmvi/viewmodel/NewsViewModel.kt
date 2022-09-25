package com.tnodev.gnewsmvi.viewmodel

import android.os.StatFs
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tnodev.gnewsmvi.NewsIntent
import com.tnodev.gnewsmvi.NewsStates
import com.tnodev.gnewsmvi.repo.RepositoryImpl
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {



    val newsChannel = Channel<NewsIntent>();
    private val _newsState = MutableStateFlow<NewsStates>(NewsStates.Loading);
    val newsStates : StateFlow<NewsStates> get() = _newsState;



    init {
        handleIntents()
    }

    private fun handleIntents() {

        viewModelScope.launch {
            newsChannel.consumeAsFlow().collect {
                when (it){
                    NewsIntent.TopHeadLinesIntent -> getTopHeadlines();
                }
            }
        }

    }

    private suspend fun getTopHeadlines() {

        RepositoryImpl().getTopHeadLines().collect {
            _newsState.value = it;
        }

    }



}