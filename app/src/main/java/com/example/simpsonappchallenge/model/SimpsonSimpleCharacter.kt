package com.example.simpsonappchallenge.model
import com.google.gson.annotations.SerializedName

data class SimpsonSimpleCharacter(
    @SerializedName("data")
    val `data`: List<DataSimple> = listOf(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("result")
    val result: Boolean = false

) { data class DataSimple(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("lastname")
    val lastname: String = "",
    @SerializedName("name")
    val name: String = "",
    )
}