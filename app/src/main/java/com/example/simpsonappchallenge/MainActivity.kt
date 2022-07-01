package com.example.simpsonappchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpsonappchallenge.ui.InitFragmentMethod
import com.example.simpsonappchallenge.ui.ListFragment


class MainActivity : AppCompatActivity(), InitFragmentMethod {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListFragment()
    }

    override fun initListFragment() {
        val listFragment = ListFragment()
        supportFragmentManager.beginTransaction().add(R.id.main_fragment_container, listFragment, "listFragment")
            .commit()
    }
}