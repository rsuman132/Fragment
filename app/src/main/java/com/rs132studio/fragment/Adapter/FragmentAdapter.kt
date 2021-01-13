package com.rs132studio.fragment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rs132studio.fragment.Fragments.Fragment_1
import com.rs132studio.fragment.Fragments.Fragment_2
import com.rs132studio.fragment.Fragments.Fragment_3

class FragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){

    private val list = listOf(Fragment_1(), Fragment_2(), Fragment_3())
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Message"
            }
            1 -> {
                return "Status"
            }
            2 -> {
                return "Calls"
            }
        }
        return super.getPageTitle(position)
    }

}