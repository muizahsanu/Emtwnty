package com.example.emtwnty.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emtwnty.R
import com.example.emtwnty.persistence.onGalleryFragment.GalleryEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_item_gallery.view.*

/** -Tanggal Pengerjaan:
 *  - 10 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class GalleryAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<GalleryEntity> = ArrayList()

    class ViewHolder constructor(
        view:View
    ):RecyclerView.ViewHolder(view){
        val imageView = view.iv_image_gallery

        fun bindContent(galleryEntity: GalleryEntity){
            val uri = galleryEntity.image
            Picasso.get()
                .load(uri)
                .resize(500,500)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.noimagepng)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_gallery,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder->{
                holder.bindContent(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun galleryAdapter(galleryEntity: List<GalleryEntity>){
        items = galleryEntity
    }


}