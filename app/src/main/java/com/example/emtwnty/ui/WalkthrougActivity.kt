package com.example.emtwnty.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.emtwnty.Adapter.PagerAdapter
import com.example.emtwnty.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_walkthroug.*
import java.util.*

/** -Tanggal Pengerjaan:
 *  - 5 Mei 2020
 *  - 6 Mei 2020
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 12 mei 2020
 *   Nama : Muiz Ahsanu Haqi
 *   Kelas: IF-5
 *   NIM  : 10117199
 * */

class WalkthrougActivity : AppCompatActivity() {

    private var checkButton: Boolean = false
    private var mTotalTab = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthroug)

        vp_walkthrough_walkthrough.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(vp_walkthrough_walkthrough)
        mTotalTab = tabLayout.tabCount

        initTabLayout()

        onOnTabSelected()

        tv_next_walkthrough.setOnClickListener(){
            if(checkButton == false){
                vp_walkthrough_walkthrough.setCurrentItem(getItem(+1),true)
            }
            else{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tv_back_walkthrough.setOnClickListener(){
            vp_walkthrough_walkthrough.setCurrentItem(getItem(-1),true)
        }
    }

    private fun getItem(i: Int): Int{
        return vp_walkthrough_walkthrough.currentItem + i
    }

    private fun initTabLayout(){
        tabLayout.apply {
            getTabAt(0)?.setIcon(R.drawable.ic_radio_button_checked_black_24dp)
            getTabAt(0)?.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_UNLABELED
            for (i in this.tabCount downTo 1){
                getTabAt(i)?.setIcon(R.drawable.ic_radio_button_unchecked_black_24dp)
                getTabAt(i)?.tabLabelVisibility = TabLayout.TAB_LABEL_VISIBILITY_UNLABELED
            }
        }
    }

    private fun onOnTabSelected(){
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab!!.setIcon(R.drawable.ic_radio_button_checked_black_24dp)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab!!.setIcon(R.drawable.ic_radio_button_unchecked_black_24dp)
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val mPosition = tab!!.position

                if(mPosition == mTotalTab-1) {
                    tv_next_walkthrough.text = "Get Started"
                    checkButton = true
                }else{
                    tv_next_walkthrough.text = "Next"
                    checkButton = false
                }
                if(mPosition >= 1){
                    tv_back_walkthrough.visibility = View.VISIBLE
                }else {
                    tv_back_walkthrough.visibility = View.GONE
                }

                tabLayout.setSelectedTabIndicator(null)
                tab.setIcon(R.drawable.ic_radio_button_checked_black_24dp)
            }
        })
    }
}
