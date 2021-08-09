package com.example.c4challengegamesuit.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.c4challengegamesuit.fragments.FirstLandingFragment
import com.example.c4challengegamesuit.fragments.SecondLandingFragment
import com.example.c4challengegamesuit.fragments.ThirdLandingFragment

class ViewPagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FirstLandingFragment()
            1 -> SecondLandingFragment()
            else -> ThirdLandingFragment()
        }
    }
}