package com.akash.edvora.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.akash.edvora.MainViewModel
import com.akash.edvora.MainViewModelFactory
import com.akash.edvora.adapters.MyAdapter
import com.akash.edvora.databinding.NearestBinding
import com.akash.edvora.repository.Repository


class Nearest : Fragment() {
    private lateinit var binding: NearestBinding
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = NearestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomRides("Panvel", "1644924365", 23, 0, 93)
        viewModel.myCustomRides.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
//                response.body()?.let { myAdapter.setData(it) }
            } else {
                Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

//    private fun setupRecyclerView() {
//        binding.rvNearest.adapter = myAdapter
//    }
}