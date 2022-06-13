package com.akash.edvora.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akash.edvora.screens.Past
import com.akash.edvora.screens.UpComing
import com.akash.edvora.screens.Nearest

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                Nearest()
            }
            1->{
                UpComing()
            }
            2->{
                Past()
            }else->{
                Fragment()
            }
        }
    }
}