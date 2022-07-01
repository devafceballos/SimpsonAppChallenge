package com.example.simpsonappchallenge.networking

import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import retrofit2.Call
import retrofit2.Response

object SimpsonAPI {

    fun getSimpsonList (listener: (List<SimpsonSimpleCharacter.DataSimple>?) -> Unit) : Call<SimpsonSimpleCharacter> {
        val request = RetrofitInstance.getApiService().getSimpsonsCharactersList()
        request.enqueue(object: retrofit2.Callback<SimpsonSimpleCharacter> {
            override fun onFailure(call: retrofit2.Call<SimpsonSimpleCharacter>, throwable: Throwable){
                listener(null)
            }
            override fun onResponse(call: retrofit2.Call<SimpsonSimpleCharacter>, response: Response<SimpsonSimpleCharacter>) {
                if (response.body() != null && response.body()!!.result ){
                    listener(response.body()!!.data)
                } else {

                    listener(null)
                }
            }
        })
        return request
    }
}