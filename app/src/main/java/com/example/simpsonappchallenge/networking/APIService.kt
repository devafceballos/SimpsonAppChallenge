package com.example.simpsonappchallenge.networking

import com.example.simpsonappchallenge.model.SimpsonDetailCharacter
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {
    @GET("/characters")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    fun getSimpsonsCharactersList(): Call<SimpsonSimpleCharacter>

    @GET("/characters")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    fun getDetailSimpsonCharacter(@Query("id") id: Int): Call<SimpsonDetailCharacter>

}