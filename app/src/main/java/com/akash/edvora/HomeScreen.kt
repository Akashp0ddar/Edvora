package com.akash.edvora

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.akash.edvora.adapters.MyAdapter
import com.akash.edvora.databinding.HomeScreenBinding
import com.akash.edvora.repository.Repository
import com.google.android.material.tabs.TabLayout


class HomeScreen : Fragment() {
    private lateinit var binding: HomeScreenBinding
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = HomeScreenBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val tabLayout = binding.tlRides
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomRides("Panvel", "1644924365", 23, 0, 93)
        viewModel.myCustomRides.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
                Log.d("onTabSelected", "onTabSelected: ${response.body()}")
                response.body()?.let { myAdapter.setData(it) }
            } else {
                Toast.makeText(requireContext(),
                    response.code(),
                    Toast.LENGTH_SHORT).show()
            }
        })


        tabLayout.addTab(tabLayout.newTab().setText("Nearest"))
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"))
        tabLayout.addTab(tabLayout.newTab().setText("Past"))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        setupRecyclerView()
                        viewModel.getCustomRides("Panvel", "1644924365", 23, 0, 93)
                        viewModel.myCustomRides.observe(requireActivity(), Observer { response ->
                            if (response.isSuccessful) {
                                Log.d("onTabSelected", "onTabSelected: ${response.body()}")
                                response.body()?.let { myAdapter.setData(it) }
                            } else {
                                Toast.makeText(requireContext(),
                                    response.code(),
                                    Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                    1 -> {
                        setupRecyclerView()
                        viewModel.getCustomRides("Panvel", "1644924365", 23, 0, 93)
                        viewModel.myCustomRides.observe(requireActivity(), Observer { response ->
                            if (response.isSuccessful) {
                                Log.d("onTabSelected", "onTabSelected: ${response.body()}")
                                response.body()?.let { myAdapter.setData(it) }
                            } else {
                                Toast.makeText(requireContext(),
                                    response.code(),
                                    Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                    2 -> {
                        setupRecyclerView()
                        viewModel.getCustomRides("Panvel", "1644924365", 23, 0, 93)
                        viewModel.myCustomRides.observe(requireActivity(), Observer { response ->
                            if (response.isSuccessful) {
                                Log.d("onTabSelected", "onTabSelected: ${response.body()}")
                                response.body()?.let { myAdapter.setData(it) }
                            } else {
                                Toast.makeText(requireContext(),
                                    response.code(),
                                    Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvNearest.adapter = myAdapter
    }

}