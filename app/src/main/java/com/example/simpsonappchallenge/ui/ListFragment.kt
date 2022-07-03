package com.example.simpsonappchallenge.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpsonappchallenge.MainActivity
import com.example.simpsonappchallenge.databinding.FragmentListBinding
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

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
        _binding = FragmentListBinding.inflate(inflater, container, false)
        // Return view
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView

        (requireActivity() as MainActivity).getSimpsonList {
            if (it != null) {
                initRecyclerView(it)
            }
        }
        addCharacter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView(simpsonList: List<SimpsonSimpleCharacter.DataSimple>){
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = CharacterAdapter(simpsonList) { character, isClickListener ->
            if(isClickListener) {
                navigateToDetail(character.id)
            }
        }
    }

    private fun navigateToDetail(characterId: Int) {
        Log.d("", "Navigate to Detail collect")
        (activity as MainActivity).initDetailFragment(characterId)
    }

    private fun addCharacter(){
        //binding button
        binding.buttonAddCharacter.setOnClickListener {
            (requireActivity() as MainActivity).initFormFragmentStep1()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}