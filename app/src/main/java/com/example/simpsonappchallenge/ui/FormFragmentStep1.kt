package com.example.simpsonappchallenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.simpsonappchallenge.MainActivity
import com.example.simpsonappchallenge.databinding.FragmentFormStep1Binding
import com.example.simpsonappchallenge.model.SimpsonDetailCharacter
import java.lang.NumberFormatException

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
            (requireActivity() as MainActivity).backToListFragment()
        }
    }

    private fun nextButton(){
        val newDataDetail = SimpsonDetailCharacter.DataDetail()
        newDataDetail.name = binding.etName.text.toString()
        newDataDetail.lastname = binding.etLastName.text.toString()
        newDataDetail.likes = binding.etLikes.text.toString()
        newDataDetail.occupation = binding.etOccupation.text.toString()
        newDataDetail.age = if (binding.etAge.text.isEmpty()) 0 else binding.etAge.text.toString().toInt()

        if (newDataDetail.isForm1FieldsCompleted())
        (requireActivity() as MainActivity).initFormFragmentStep2(newDataDetail)
            else Toast.makeText(requireContext(), "Some fields are empty", Toast.LENGTH_LONG).show()
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