package com.example.emtwnty.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.emtwnty.Adapter.PagerAdapter
import com.example.emtwnty.R
import kotlinx.android.synthetic.main.activity_walkthroug.*

/** -Tanggal Pengerjaan:
 *   - 5 Mei 2020
 *   - 6 Mei 2020
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 11 mei 2020
 *   Nama : Muiz Ahsanu Haqi
 *   Kelas: IF-5
 *   NIM  : 10117199
 * */

class WalkthrougActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthroug)

        vp_walkthrough_walkthrough.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.getTabAt(3)?.setText("yoman")
        tv_next_walkthrough.setOnClickListener(){
            vp_walkthrough_walkthrough.setCurrentItem(getItem(+1),true)
        }
        tv_back_walkthrough.setOnClickListener(){
            vp_walkthrough_walkthrough.setCurrentItem(getItem(-1),true)
        }
        tv_skip_walkthrough.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun getItem(i: Int): Int{
        if(vp_walkthrough_walkthrough.currentItem+i == 0){
            tv_back_walkthrough.visibility = View.INVISIBLE
        }
        else {
            tv_back_walkthrough.visibility = View.VISIBLE
        }
        return vp_walkthrough_walkthrough.currentItem + i
    }
}
