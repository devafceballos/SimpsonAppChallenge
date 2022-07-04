package com.example.simpsonappchallenge.networking

import com.example.simpsonappchallenge.model.SimpsonDetailCharacter
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import retrofit2.Call
import retrofit2.http.*

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

    @POST("/characters")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    fun putNewSimpsonCharacter(@Body simpsonDataDetail: SimpsonDetailCharacter.DataDetail): Call<SimpsonDetailCharacter>

    @DELETE("/characters")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    fun deleteSimpsonCharacter(@Query("id") id: Int): Call<SimpsonSimpleCharacter>

}