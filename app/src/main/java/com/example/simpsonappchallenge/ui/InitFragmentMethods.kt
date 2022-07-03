package com.example.simpsonappchallenge.ui

import com.example.simpsonappchallenge.model.SimpsonDetailCharacter

interface InitFragmentMethods {

    fun initListFragment()

    fun initDetailFragment(characterId: Int)

    fun initFormFragmentStep1()

    fun initFormFragmentStep2(dataDetail: SimpsonDetailCharacter.DataDetail)

}