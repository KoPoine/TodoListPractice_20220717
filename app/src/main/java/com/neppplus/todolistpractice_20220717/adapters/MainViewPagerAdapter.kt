package com.neppplus.todolistpractice_20220717.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.neppplus.todolistpractice_20220717.fragments.GoalFragment
import com.neppplus.todolistpractice_20220717.fragments.SettingFragment
import com.neppplus.todolistpractice_20220717.fragments.TodoFragment

class MainViewPagerAdapter (fa : FragmentActivity) : FragmentStateAdapter(fa) {
//    몇장짜리 ViewPager인지
    override fun getItemCount(): Int {
        return 3
    }

//    각 포지션에 어떤 프래그먼트를 보낼껀지
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TodoFragment()
            1 -> GoalFragment()
            else -> SettingFragment()
        }
    }

}