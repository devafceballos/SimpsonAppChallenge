package com.example.simpsonappchallenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.simpsonappchallenge.MainActivity
import com.example.simpsonappchallenge.R
import com.example.simpsonappchallenge.databinding.FragmentDetailBinding
import com.example.simpsonappchallenge.model.SimpsonDetailCharacter
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private var parameterId: Int? = null
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            parameterId = it.getInt("idKey")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).getDetail(parameterId!!) {
            if (it != null){
                renderCharacter(it)
            } else {
                Toast.makeText(context, "Error al cargar detalle", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Render character method
    private fun renderCharacter(character: SimpsonDetailCharacter.DataDetail){
        _binding?.detailName?.text = character.name
        _binding?.detailLastName?.text = character.lastname
        _binding?.tvAge?.text = character.age.toString()
        _binding?.tvOccupation?.text = character.occupation
        _binding?.tvLikes?.text = character.likes
        _binding?.tvOther?.text = character.other
        loadImage(character, binding.imageDetail)
    }

    //Load image with Picasso
    private fun loadImage(character: SimpsonDetailCharacter.DataDetail, view: ImageView) {
        Picasso.get()
            .load(character.photo)
            .into(view)
    }

    companion object {

        @JvmStatic
        fun newInstance(characterId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt("idKey", characterId)
                }
            }
    }
}