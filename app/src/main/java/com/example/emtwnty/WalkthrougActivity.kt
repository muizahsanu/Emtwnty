package com.example.emtwnty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.emtwnty.Adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_walkthroug.*

class WalkthrougActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthroug)

        vp_walkthrough_walkthrough.adapter = PagerAdapter(supportFragmentManager)
        tv_next_walkthrough.setOnClickListener(){
            vp_walkthrough_walkthrough.setCurrentItem(getItem(+1),true)
        }
        tv_back_walkthrough.setOnClickListener(){
            vp_walkthrough_walkthrough.setCurrentItem(getItem(-1),true)
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
