package com.tnodev.gnewsmvi.service

import com.tnodev.example.NewsData
import com.tnodev.gnewsmvi.model.Constants
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {


    @GET("top-headlines?lang=en&token=${Constants.API_KEY}")
    suspend fun getTopHeadLines() : Response<NewsData>

}