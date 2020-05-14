package com.example.emtwnty.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emtwnty.R
import com.example.emtwnty.persistence.MusicVideoEntity
import kotlinx.android.synthetic.main.rv_item_music.view.*

/** -Tanggal Pengerjaan:
 *  - 11 Mei 2020
 *  - 14 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class MusicVideoAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<MusicVideoEntity> = ArrayList()
    private lateinit var mClickListener: onClickItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_music,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is ViewHolder->{
                holder.bindContent(items.get(position),mClickListener)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun MusicVideoAdapter(musicVideo: List<MusicVideoEntity>,clickListener: onClickItemListener){
        items = musicVideo
        mClickListener = clickListener
    }

    class ViewHolder constructor(
        view: View
    ): RecyclerView.ViewHolder(view){
        val title = view.tv_title_music
        val penyanyi = view.tv_penyanyi_music

        fun bindContent(musicVideo: MusicVideoEntity, clickListener: onClickItemListener){
            title.text = musicVideo.judulMusic
            penyanyi.text = musicVideo.penyanyi

            itemView.btn_play_music.setOnClickListener {
                clickListener.onItemClick(musicVideo,adapterPosition)
            }
        }
    }

    interface onClickItemListener{
        fun onItemClick(musicVideo: MusicVideoEntity, position: Int)
    }

}