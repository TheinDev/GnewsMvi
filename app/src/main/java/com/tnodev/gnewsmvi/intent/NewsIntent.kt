package com.tnodev.gnewsmvi

import com.tnodev.example.NewsData


sealed class NewsIntent{

    object  TopHeadLinesIntent : NewsIntent()
}

sealed class NewsStates{

    data class Success(val news : NewsData) : NewsStates();
    data class Error(val erroMessage: String) : NewsStates();
    object  Loading : NewsStates();
}
