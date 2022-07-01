package com.example.simpsonappchallenge.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun getApiService(): APIService = get().create(APIService::class.java)

    private fun get(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://test-simpsons-assistcard.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}