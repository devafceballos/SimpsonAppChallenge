package com.example.simpsonappchallenge.networking

import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {
    @GET("/characters")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    fun getSimpsonsCharactersList(): Call<SimpsonSimpleCharacter>
}