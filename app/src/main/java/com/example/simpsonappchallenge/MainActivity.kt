package com.example.simpsonappchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpsonappchallenge.databinding.ActivityMainBinding
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import com.example.simpsonappchallenge.networking.SimpsonAPI
import com.example.simpsonappchallenge.ui.InitFragmentMethod
import com.example.simpsonappchallenge.ui.ListFragment


class MainActivity : AppCompatActivity(), InitFragmentMethod {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListFragment()
    }

    // This method init ListFragment

    override fun initListFragment() {
        val listFragment = ListFragment()
        supportFragmentManager.beginTransaction().add(R.id.main_fragment_container, listFragment, "listFragment")
            .commit()
    }

    //This method get the characters´s list (Retrofit)

    fun getSimpsonList(listener: (List<SimpsonSimpleCharacter.DataSimple>?) -> Unit) {
        SimpsonAPI.getSimpsonList {
            if (it != null){
                listener(it)
            } else {
                listener(null)
            }
        }
    }


}