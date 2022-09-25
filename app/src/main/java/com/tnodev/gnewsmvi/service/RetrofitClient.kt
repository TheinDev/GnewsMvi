package com.tnodev.gnewsmvi.service

import androidx.viewbinding.BuildConfig
import com.tnodev.gnewsmvi.model.Constants

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object {

        private val retrofit by lazy {

            val looging = HttpLoggingInterceptor()
            looging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(looging)
                .build();

            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        val api by lazy {
            retrofit.create(NewsService::class.java)
        }
    }
}

//            val client = OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .build()
//            Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//        }
//        val api by lazy {
//            retrofit.create(ApiService::class.java)
//        }
//    }
//}