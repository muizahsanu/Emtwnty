package com.example.emtwnty.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emtwnty.R
import com.example.emtwnty.persistence.ViewPagerModel
import kotlinx.android.synthetic.main.vp_item_walkthrough.view.*

/** -Tanggal Pengerjaan:
 *  - 5 Mei 2020
 *  - 6 Mei 2020
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 13 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class PagerAdapter(): RecyclerView.Adapter<PagerAdapter.ViewHolderPager>() {
    private var items:List<ViewPagerModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPager {
        return ViewHolderPager(
            LayoutInflater.from(parent.context).inflate(R.layout.vp_item_walkthrough,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderPager, position: Int) {
        holder.bindContent(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setPagerAdapter(pagerMode: List<ViewPagerModel>){
        items = pagerMode
    }

    class ViewHolderPager constructor(
        view: View
    ): RecyclerView.ViewHolder(view){
        val title = view.vp_title
        val desc = view.vp_desc
        val image = view.vp_image

        fun bindContent(viewPagerModel: ViewPagerModel){
            title.text = viewPagerModel.title
            desc.text = viewPagerModel.desc
            image.setImageResource(viewPagerModel.image)
        }
    }
}