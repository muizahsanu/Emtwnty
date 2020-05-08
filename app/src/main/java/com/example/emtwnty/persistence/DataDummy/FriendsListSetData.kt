package com.example.emtwnty.persistence.DataDummy

import com.example.emtwnty.R
import com.example.emtwnty.persistence.FriendsList

/** -Tanggal Pengerjaan:
*  - 7 Mei 2020
 *  - 8 mei 2020
*  Nama : Muiz Ahsanu Haqi
*  Kelas: IF-5
*  NIM  : 10117199
* */

class FriendsListSetData {
    companion object{
        fun createDataSet(): ArrayList<FriendsList>{
            val list = ArrayList<FriendsList>()
            list.add(
                FriendsList(
                    1,
                    "Faiz Zainul",
                    "Pukis",
                    R.drawable.pukis
                )
            )
            list.add(
                FriendsList(
                    2,
                    "Iqbal Atma",
                    "Bale",
                    R.drawable.iqbal
                )
            )
            list.add(
                FriendsList(
                    3,
                    "Annisa Salsabilla",
                    "Ann",
                    R.drawable.pukis
                )
            )
            return list
        }
    }
}