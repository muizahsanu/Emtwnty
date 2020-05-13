package com.example.emtwnty.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.emtwnty.Adapter.PagerAdapter
import com.example.emtwnty.R
import com.example.emtwnty.persistence.ViewPagerModel
import kotlinx.android.synthetic.main.activity_walkthroug.*

/** -Tanggal Pengerjaan:
 *  - 5 Mei 2020
 *  - 6 Mei 2020
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 12 mei 2020
 *  - 13 mei 2020
 *   Nama : Muiz Ahsanu Haqi
 *   Kelas: IF-5
 *   NIM  : 10117199
 * */

class WalkthrougActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: PagerAdapter
    private var data:List<ViewPagerModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthroug)

        setData()

        vp2_walkthrough.adapter = viewPagerAdapter
        vp2_walkthrough.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        indicator.setViewPager(vp2_walkthrough)

        vp2_walkthrough.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                getStartedAnimation(position)
            }
        })

        btn_getStarted_wlakthrough.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun setData(){
        data = ViewPagerModel.setDataViewPager()
        viewPagerAdapter = PagerAdapter()
        viewPagerAdapter.setPagerAdapter(data)
    }

    fun getStartedAnimation(position:Int){
        if(position == data.size-1){
            btn_getStarted_wlakthrough.apply {
                alpha = 0f
                visibility = View.VISIBLE
                animate()
                    .alpha(1f)
                    .setDuration(1500)
            }
        }
        else{
            btn_getStarted_wlakthrough.visibility = View.INVISIBLE
        }
    }
}
