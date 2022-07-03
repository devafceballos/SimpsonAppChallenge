package com.example.simpsonappchallenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpsonappchallenge.R
import com.example.simpsonappchallenge.databinding.FragmentFormStep1Binding
import com.example.simpsonappchallenge.model.SimpsonDetailCharacter

class FormFragmentStep1 : Fragment() {

    private var _binding: FragmentFormStep1Binding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentFormStep1Binding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Next button logic
        binding.buttonNext.setOnClickListener {
            nextButton()
        }

        //Cancel button logic
        binding.buttonCancel.setOnClickListener {
            //add back logic. To the listFragment!
        }

    }

    private fun nextButton() {

        val newCharacterData = SimpsonDetailCharacter.DataDetail()
        newCharacterData.name = binding.etName.text.toString()
        newCharacterData.lastname = binding.etLastName.text.toString()
        newCharacterData.age = binding.etAge.text.toString().toInt()
        newCharacterData.likes = binding.etLikes.text.toString()
        newCharacterData.occupation = binding.etOccupation.text.toString()
        //add the fragmentForm step 2 method!
    }

    companion object {

        @JvmStatic
        fun newInstanceOfFormFragment() =
            FormFragmentStep1().apply {
                arguments = Bundle().apply {

                }
            }
    }
}