package com.akash.edvora.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akash.edvora.R
import com.akash.edvora.adapters.MyAdapter
import com.akash.edvora.databinding.PastBinding
import com.akash.edvora.databinding.UpComingBinding


class UpComing : Fragment() {
    private lateinit var binding: UpComingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = UpComingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUpcoming.adapter = MyAdapter()


    }
}