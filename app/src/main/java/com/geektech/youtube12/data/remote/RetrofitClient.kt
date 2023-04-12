package com.geektech.youtube12.data.remote

import com.geektech.youtube12.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    fun create():ApiService{

        val interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client=OkHttpClient.Builder()
            .writeTimeout(5,TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .connectTimeout(5,TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        val retrofit=Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }


}