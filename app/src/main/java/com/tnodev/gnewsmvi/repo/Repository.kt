package com.tnodev.gnewsmvi.repo

import com.tnodev.gnewsmvi.NewsStates
import com.tnodev.gnewsmvi.service.RetrofitService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface  Repository{

    suspend fun getTopHeadLines() : Flow<NewsStates>
}
class RepositoryImpl : Repository {



    override suspend fun getTopHeadLines(): Flow<NewsStates> {
       return flow {

            emit(NewsStates.Loading)

            val response = RetrofitService.api.getTopHeadLines()
            if (response.isSuccessful){
                emit(NewsStates.Success(response.body()!!))
            }else{
                emit(NewsStates.Error(response.errorBody().toString()))
            }

        }
    }
}