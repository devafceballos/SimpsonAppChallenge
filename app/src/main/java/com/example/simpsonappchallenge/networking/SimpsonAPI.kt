package com.example.simpsonappchallenge.networking

import android.content.Context
import android.widget.Toast
import com.example.simpsonappchallenge.MainActivity
import com.example.simpsonappchallenge.databinding.FragmentListBinding
import com.example.simpsonappchallenge.model.SimpsonDetailCharacter
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import retrofit2.Call
import retrofit2.Response

object SimpsonAPI {

    fun getSimpsonList(listener: (List<SimpsonSimpleCharacter.DataSimple>?) -> Unit): Call<SimpsonSimpleCharacter> {
        val request = RetrofitInstance.getApiService().getSimpsonsCharactersList()
        request.enqueue(object : retrofit2.Callback<SimpsonSimpleCharacter> {
            override fun onFailure(call: Call<SimpsonSimpleCharacter>, throwable: Throwable) {
                listener(null)
            }

            override fun onResponse(
                call: Call<SimpsonSimpleCharacter>,
                response: Response<SimpsonSimpleCharacter>,
            ) {
                if (response.body() != null && response.body()!!.result) {
                    listener(response.body()!!.data)
                } else {
                    listener(null)
                }
            }
        })
        return request
    }

    fun getDetail(
        characterId: Int,
        listener: (SimpsonDetailCharacter.DataDetail?) -> Unit,
    ): Call<SimpsonDetailCharacter> {
        val request = RetrofitInstance.getApiService().getDetailSimpsonCharacter(characterId)
        request.enqueue(object : retrofit2.Callback<SimpsonDetailCharacter> {
            override fun onFailure(call: Call<SimpsonDetailCharacter>, throwable: Throwable) {
                listener(null)
            }

            override fun onResponse(
                call: Call<SimpsonDetailCharacter>,
                response: Response<SimpsonDetailCharacter>,
            ) {
                if (response.body() != null && response.body()!!.result) {
                    listener(response.body()!!.dataDetail)
                } else {
                    listener(null)
                }
            }
        })
        return request
    }

    fun createNewSimpsonCharacter(
        simpsonDataDetail: SimpsonDetailCharacter.DataDetail,
        listener: (Boolean) -> Unit
    ) {
        RetrofitInstance.getApiService().putNewSimpsonCharacter(simpsonDataDetail)
            .enqueue(object : retrofit2.Callback<SimpsonDetailCharacter> {
                override fun onResponse(
                    call: Call<SimpsonDetailCharacter>,
                    response: Response<SimpsonDetailCharacter>,
                ) {
                    if (response.isSuccessful && response.body() != null && response.body()!!.result) {
                        listener(true)

                    } else {
                        listener(false)
                    }
                }

                override fun onFailure(call: Call<SimpsonDetailCharacter>, t: Throwable) {
                    listener(false)
                }
            })
    }

    fun deleteCharacterAction(characterId: Int, context: Context, binding: FragmentListBinding) {

        RetrofitInstance.getApiService().deleteSimpsonCharacter(characterId)
            .enqueue(object : retrofit2.Callback<SimpsonSimpleCharacter> {
                override fun onResponse(
                    call: Call<SimpsonSimpleCharacter>,
                    response: Response<SimpsonSimpleCharacter>,
                ) {
                    if (response.isSuccessful && response.body() != null && response.body()!!.result) {
                        binding.recyclerView.removeAllViews()
                        (context as MainActivity).backToListFragment()

                    } else Toast.makeText(context, "Failure delete", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<SimpsonSimpleCharacter>, t: Throwable) {
                }
            })
    }
}