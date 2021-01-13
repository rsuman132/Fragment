package com.rs132studio.fragment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rs132studio.fragment.Fragments.BottomFragment1
import com.rs132studio.fragment.Fragments.BottomFragment2
import com.rs132studio.fragment.Fragments.BottomFragment3
import com.rs132studio.fragment.Fragments.BottomFragment4
import com.rs132studio.fragment.R

class BottomFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val bottomItemList = listOf(BottomFragment1(), BottomFragment2(), BottomFragment3(), BottomFragment4())
    override fun getCount(): Int {
        return bottomItemList.size
    }

    override fun getItem(position: Int): Fragment {
        return bottomItemList[position]
    }

}