package com.example.simpsonappchallenge.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpsonappchallenge.MainActivity
import com.example.simpsonappchallenge.R
import com.example.simpsonappchallenge.databinding.FragmentFormStep2Binding
import com.example.simpsonappchallenge.model.SimpsonDetailCharacter
import com.example.simpsonappchallenge.networking.SimpsonAPI

class FormFragmentStep2 : Fragment() {

    var dataDetail: SimpsonDetailCharacter.DataDetail = SimpsonDetailCharacter.DataDetail()

    private var _binding: FragmentFormStep2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dataDetail = it.getSerializable("keyNewChar") as SimpsonDetailCharacter.DataDetail
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormStep2Binding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //NavigationBar
        binding.form2ToolBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.form2ToolBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        //Save button
        binding.buttomSave.setOnClickListener {
            saveButton()
        }
        //Cancel button
        binding.buttonCancel2.setOnClickListener {
            (requireActivity() as MainActivity).backToListFragment()
        }
    }

    private fun saveButton() {
        dataDetail.other = binding.etBio.text.toString()
        dataDetail.photo = binding.etUrl.text.toString()

        //Block button after save new character
        SimpsonAPI.createNewSimpsonCharacter(dataDetail, requireContext())
        binding.buttomSave.isEnabled = false

        //Handler to wait and show block button
        Handler(Looper.getMainLooper()).postDelayed({
            val activity = requireActivity()
            if (activity is MainActivity) {
                activity.backToListFragment()
            }
        }, 2000)
    }

    companion object {
        @JvmStatic
        fun newInstanceOfFormFragmentStep2(dataDetail: SimpsonDetailCharacter.DataDetail) =
            FormFragmentStep2().apply {
                arguments = Bundle().apply {
                    putSerializable("keyNewChar", dataDetail)
                }
            }
    }
}