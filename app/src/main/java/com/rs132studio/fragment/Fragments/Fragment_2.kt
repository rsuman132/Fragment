package com.rs132studio.fragment.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.rs132studio.fragment.Adapter.BottomFragmentAdapter
import com.rs132studio.fragment.R
import kotlinx.android.synthetic.main.activity_main.*

class Fragment_2 : Fragment() {

    //buttons
    private lateinit var homeImg: ImageView
    private lateinit var searchImg: ImageView
    private lateinit var addImg: ImageView
    private lateinit var accountImg: ImageView

    //bottom fragments

    private lateinit var viewPager2: ViewPager
    private lateinit var bottomFragmentAdapter: BottomFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewPager2 = view.findViewById(R.id.bottom_viewpager)

        homeImg = view.findViewById(R.id.bottom_home)
        searchImg = view.findViewById(R.id.bottom_search)
        addImg = view.findViewById(R.id.bottom_add)
        accountImg = view.findViewById(R.id.bottom_account)

        //imageView onclick

        homeImg.setOnClickListener{
            viewPager2.currentItem = 0
        }

        searchImg.setOnClickListener{
            viewPager2.currentItem = 1
        }

        addImg.setOnClickListener{
            viewPager2.currentItem = 2
        }

        accountImg.setOnClickListener{
            viewPager2.currentItem = 3
        }


        bottomFragmentAdapter = BottomFragmentAdapter(childFragmentManager)
        viewPager2.adapter = bottomFragmentAdapter
        viewPager2.offscreenPageLimit = 4

        viewPager2.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageScrollStateChanged(state: Int) {
                viewPager2.currentItem = 0
            }

            override fun onPageSelected(position: Int) {
                changingTab(position)
            }
        })
    }

    private fun changingTab(position: Int) {
        if (position == 0 ){
            homeImg.setImageResource(R.drawable.ic_baseline_home_change)
            searchImg.setImageResource(R.drawable.ic_baseline_search)
            addImg.setImageResource(R.drawable.ic_baseline_add)
            accountImg.setImageResource(R.drawable.ic_baseline_account)
        } else if (position == 1){
            homeImg.setImageResource(R.drawable.ic_baseline_home)
            searchImg.setImageResource(R.drawable.ic_baseline_search_change)
            addImg.setImageResource(R.drawable.ic_baseline_add)
            accountImg.setImageResource(R.drawable.ic_baseline_account)
        } else if (position == 2){
            homeImg.setImageResource(R.drawable.ic_baseline_home)
            searchImg.setImageResource(R.drawable.ic_baseline_search)
            addImg.setImageResource(R.drawable.ic_baseline_add_change)
            accountImg.setImageResource(R.drawable.ic_baseline_account)
        }else {
            homeImg.setImageResource(R.drawable.ic_baseline_home)
            searchImg.setImageResource(R.drawable.ic_baseline_search)
            addImg.setImageResource(R.drawable.ic_baseline_add)
            accountImg.setImageResource(R.drawable.ic_baseline_account_change)
        }

    }
}