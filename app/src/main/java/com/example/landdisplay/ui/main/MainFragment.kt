/*
 * Created by Lukas (LukaLike) on Fri, Jun 25, '21.
 * Copyright (c) 2021. All rights reserved.
 */

package com.example.landdisplay.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.landdisplay.R
import com.example.landdisplay.data.EventObserver
import com.example.landdisplay.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
            .apply { viewModel = this@MainFragment.viewModel }

        configureObservers()

        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    private fun configureObservers() {
        viewModel.openClickEvent.observe(viewLifecycleOwner, EventObserver {
            navigateToMapFragment()
        })
    }

    private fun navigateToMapFragment() {
        findNavController().navigate(R.id.action_mainFragment_to_mapFragment)
    }

}