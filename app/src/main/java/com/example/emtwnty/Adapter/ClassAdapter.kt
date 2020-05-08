package com.example.emtwnty.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emtwnty.persistence.FriendsList
import com.example.emtwnty.R
import kotlinx.android.synthetic.main.recycler_item_friends.view.*

/** -Tanggal Pengerjaan:
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class ClassAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items:List<FriendsList> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_friends,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder ->
                holder.bindFriendsList(items.get(position))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun friendListAdapter(friendsListModel: List<FriendsList>){
        items = friendsListModel
    }

    class ViewHolder constructor(
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

}