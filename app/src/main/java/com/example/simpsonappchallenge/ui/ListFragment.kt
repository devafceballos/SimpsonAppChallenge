package com.example.simpsonappchallenge.ui

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpsonappchallenge.MainActivity
import com.example.simpsonappchallenge.databinding.FragmentListBinding
import com.example.simpsonappchallenge.model.SimpsonSimpleCharacter
import com.example.simpsonappchallenge.networking.SimpsonAPI.deleteCharacterAction

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        //App bar
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
            } else {
                Toast.makeText(context, "Service fail", Toast.LENGTH_SHORT).show()
            }
        }
        addCharacter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView(simpsonList: List<SimpsonSimpleCharacter.DataSimple>) {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = CharacterAdapter(simpsonList) { character, isClickListener ->
            if (isClickListener) {
                navigateToDetail(character.id)
            } else {
                showDeleteDialog(character)
            }
        }
    }

    private fun navigateToDetail(characterId: Int) {
        Log.d("", "Navigate to Detail collect")
        (activity as MainActivity).initDetailFragment(characterId)
    }

    private fun addCharacter() {
        binding.buttonAddCharacter.setOnClickListener {
            (requireActivity() as MainActivity).initFormFragmentStep1()
        }
    }

    //Dialog method for delete action
    private fun showDeleteDialog(character: SimpsonSimpleCharacter.DataSimple) {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete character?")
        builder.setMessage("Delete ${character.name + " " + character.lastname}?")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(requireContext(),
                "Character delete", Toast.LENGTH_SHORT).show()
            deleteCharacterAction(character.id, requireContext(), binding)

        }
        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(requireContext(),
                android.R.string.no, Toast.LENGTH_SHORT)
        }
        builder.show()
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