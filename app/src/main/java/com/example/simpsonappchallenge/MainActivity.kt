package com.example.simpsonappchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpsonappchallenge.databinding.ActivityMainBinding
import com.example.simpsonappchallenge.model.SimpsonDetailCharacter
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import com.example.simpsonappchallenge.networking.SimpsonAPI
import com.example.simpsonappchallenge.ui.DetailFragment
import com.example.simpsonappchallenge.ui.FormFragmentStep1
import com.example.simpsonappchallenge.ui.InitFragmentMethods
import com.example.simpsonappchallenge.ui.ListFragment


class MainActivity : AppCompatActivity(), InitFragmentMethods {
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

    // This method init DetailFragment
    override fun initDetailFragment(characterId: Int) {
        val detailFragment = DetailFragment.newInstance(characterId)
        supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container, detailFragment, "detailFragment").addToBackStack(null)
            .commit()
    }

    //This method init first step of FormFragment
    override fun initFormFragmentStep1() {
        val formFragment = FormFragmentStep1.newInstanceOfFormFragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container, formFragment, "formularyFragment1").addToBackStack(null)
            .commit()
    }
    //This method init second step of FormFragment
    override fun initFormFragmentStep2(dataDetail: SimpsonDetailCharacter.DataDetail) {
        TODO("Not yet implemented")
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

    //This method get the characters´s detail (Retrofit)
    fun getDetail(characterId: Int, listener: (SimpsonDetailCharacter.DataDetail?) -> Unit) {
        SimpsonAPI.getDetail(characterId) {
            if (it != null){
                listener(it)
            } else {
                listener(null)
            }
        }
    }

}