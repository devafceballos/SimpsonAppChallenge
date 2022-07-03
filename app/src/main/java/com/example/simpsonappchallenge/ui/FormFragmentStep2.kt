package com.example.simpsonappchallenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpsonappchallenge.R

class FormFragmentStep2 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_step2, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FormFragmentStep2().apply {
                arguments = Bundle().apply {

                }
            }
    }
}