package com.example.emtwnty.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.emtwnty.Fragmens.FirstFragment
import com.example.emtwnty.Fragmens.SecondFragment
import com.example.emtwnty.Fragmens.ThirdFragment

class PagerAdapter(fragAdapter: FragmentManager): FragmentPagerAdapter(fragAdapter){

    // List yang menampung Fragments
    private val pages = listOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()
    )

    // Menentukan posisi fragment
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    // Memberikan Judul/title pada setiap Fragment
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> "Third Tab"
        }
    }

}