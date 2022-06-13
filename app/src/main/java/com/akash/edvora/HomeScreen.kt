package com.akash.edvora

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akash.edvora.adapters.MyAdapter
import com.akash.edvora.adapters.ViewPagerAdapter
import com.akash.edvora.databinding.HomeScreenBinding
import com.google.android.material.tabs.TabLayout


class HomeScreen : Fragment() {
    private lateinit var binding: HomeScreenBinding
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


        val tabLayout = binding.tlRides

//        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        binding.rvNearest.adapter = MyAdapter()

        tabLayout.addTab(tabLayout.newTab().setText("Nearest"))
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"))
        tabLayout.addTab(tabLayout.newTab().setText("Past"))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
//                        binding.rvNearest.adapter = MyAdapter()
                    }
                    1 -> {
//                        binding.rvNearest.adapter = MyAdapter()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

}