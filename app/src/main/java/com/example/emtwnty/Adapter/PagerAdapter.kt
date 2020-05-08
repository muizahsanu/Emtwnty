package com.example.emtwnty.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.emtwnty.ui.Walkthrough.FirstFragment
import com.example.emtwnty.ui.Walkthrough.SecondFragment
import com.example.emtwnty.ui.Walkthrough.ThirdFragment

/** -Tanggal Pengerjaan:
 *  - 5 Mei 2020
 *  - 6 Mei 2020
 *  - 7 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class PagerAdapter(fragAdapter: FragmentManager): FragmentPagerAdapter(
    fragAdapter, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    // List yang menampung ui
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