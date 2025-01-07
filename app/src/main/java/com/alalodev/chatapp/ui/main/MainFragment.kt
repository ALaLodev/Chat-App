package com.alalodev.chatapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alalodev.chatapp.R
import com.alalodev.chatapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewmodel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.btnChat.setOnClickListener {
            if(!binding.tilName.text.isNullOrEmpty()){
                viewmodel.saveNickName(binding.tilName.text.toString())
                findNavController().navigate(R.id.action_mainFragment_to_chatFragment)
            }else{
                Toast.makeText(context,"Introduce nombre usuario", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}