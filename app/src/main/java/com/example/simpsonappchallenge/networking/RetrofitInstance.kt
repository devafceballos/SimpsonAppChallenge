package com.example.simpsonappchallenge.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    fun getApiService(): APIService = get().create(APIService::class.java)

    private fun get(): Retrofit {
        return Retrofit.Builder()
            .client(clientHttpBuilder())
            .baseUrl("https://test-simpsons-assistcard.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun clientHttpBuilder(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }
}