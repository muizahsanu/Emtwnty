package com.example.emtwnty.persistence

import com.example.emtwnty.R

/** -Tanggal Pengerjaan:
 *  - 13 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

data class ViewPagerModel (
    val title: String,
    val desc: String,
    val image: Int
){
    companion object{
        fun setDataViewPager(): ArrayList<ViewPagerModel>{
            val list = ArrayList<ViewPagerModel>()
            list.add(
                ViewPagerModel("Title1","Description1", R.drawable.content)
            )
            list.add(
                ViewPagerModel("Title2","Description2", R.drawable.exploreme)
            )
            list.add(
                ViewPagerModel("Title2","Description2", R.drawable.list)
            )
            return list
        }
    }
}