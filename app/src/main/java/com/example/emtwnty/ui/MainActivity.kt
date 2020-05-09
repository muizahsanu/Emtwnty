package com.example.emtwnty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.emtwnty.R
import com.example.emtwnty.ui.fragments.DailyFragment
import com.example.emtwnty.ui.fragments.GalleryFragment
import com.example.emtwnty.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

/** -Tanggal Pengerjaan:
*  - 5 Mei 2020
*  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 10 mei 2020
*  Nama : Muiz Ahsanu Haqi
*  Kelas: IF-5
*  NIM  : 10117199
* */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu: Menu = bottom_nav.menu
        selectedMenu(menu.getItem(0))
        bottom_nav.setOnNavigationItemSelectedListener{
            item: MenuItem -> selectedMenu(item)
            false
        }
    }
    private fun selectedMenu(item: MenuItem){
        item.isChecked = true
        when(item.itemId){
            R.id.home_menu -> selectedFragment(HomeFragment.getInstance())
            R.id.daily_menu -> selectedFragment(DailyFragment.getInstance())
            R.id.gallery_menu -> selectedFragment(GalleryFragment.getInstance())
        }
    }
    fun selectedFragment(fragment: Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout_home,fragment)
        transaction.commit()
    }
}
