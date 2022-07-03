package com.example.simpsonappchallenge.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SimpsonDetailCharacter(
    @SerializedName("data")
    val dataDetail: DataDetail = DataDetail(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("result")
    val result: Boolean = false

) {
    data class DataDetail(
        @SerializedName("age")
        var age: Int = 0,
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("lastname")
        var lastname: String = "",
        @SerializedName("likes")
        var likes: String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("occupation")
        var occupation: String = "",
        @SerializedName("other")
        var other: String = "",
        @SerializedName("photo")
        var photo: String = ""
    ) : Serializable
}