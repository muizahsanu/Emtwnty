package com.example.emtwnty.Adapter

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emtwnty.R
import com.example.emtwnty.persistence.Daily
import com.example.emtwnty.persistence.FriendsList
import kotlinx.android.synthetic.main.rv_item_friends.view.*
import kotlinx.android.synthetic.main.rv_item_daily.view.*
import java.lang.IllegalArgumentException

/** -Tanggal Pengerjaan:
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  - 14 mei 2020
 *  - 16 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class ClassAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items:List<Any> = ArrayList()

    private lateinit var mClickListener: onClickItemListener

    companion object{
        private const val FRIENDS_LIST = 0
        private const val DAILY = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position]){
            is FriendsList -> FRIENDS_LIST
            is Daily -> DAILY
            else -> throw IllegalArgumentException("Undefined View Type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            FRIENDS_LIST -> ViewHolderFriendsList(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item_friends,parent,false)
            )
            DAILY -> ViewHolderDaily(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item_daily,parent,false)
            )
            else -> throw throw IllegalArgumentException("Undifined View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            FRIENDS_LIST -> {
                val friendsListHolder = holder as ViewHolderFriendsList
                friendsListHolder.bindFriendsList(items[position] as FriendsList)
            }
            DAILY ->{
                val dailyHolder = holder as ViewHolderDaily
                dailyHolder.bindDaily(items[position] as Daily, mClickListener)
            }
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun friendListAdapter(friendsListModel: List<FriendsList>){
        items = friendsListModel
    }
    fun dailyAdapter(daily: List<Daily>,clickListener: onClickItemListener){
        items = daily
        mClickListener = clickListener
    }

    class ViewHolderFriendsList constructor(
        itemView:View
    ): RecyclerView.ViewHolder(itemView){
        val namaPanjang = itemView.tv_namaPanjang_friends
        val namaPanggilan = itemView.tv_namaPanggilan_friends
        val image = itemView.iv_profile_friends
        fun bindFriendsList(friendsList: FriendsList){
            namaPanjang.text = friendsList.nama_lengkap
            namaPanggilan.text = friendsList.nama_panggilan
            image.setImageResource(friendsList.image)
        }
    }

    class ViewHolderDaily constructor(
        view: View
    ): RecyclerView.ViewHolder(view){
        val judulAktivitas = view.tv_namaAktivitas_rvDaily
        val waktuAktivitas = view.tv_waktuAktivitas_rvDaily
        val checkBox = view.btn_check_itemsDaily

        fun bindDaily(daily: Daily, clickListener: onClickItemListener){
            judulAktivitas.text = daily.judul_aktivitas
            waktuAktivitas.text = daily.waktu_aktivitas

            if(daily.check == "false"){
                checkBox.setImageResource(R.drawable.ic_checkbox_uncompletedp)
            }
            else{
                checkBox.setImageResource(R.drawable.ic_check_box_black_24dp)
            }

            itemView.btn_check_itemsDaily.setOnClickListener {
                clickListener.onItemClick(daily,adapterPosition)
            }
        }
    }

    interface onClickItemListener{
        fun onItemClick(daily: Daily, position: Int)
    }

}