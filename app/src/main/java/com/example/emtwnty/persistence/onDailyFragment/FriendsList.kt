package com.example.emtwnty.persistence.onDailyFragment

import androidx.room.Entity
import androidx.room.PrimaryKey

/** -Tanggal Pengerjaan:
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Entity(tableName = "friendslist")
data class FriendsList(
    @PrimaryKey
    val id: Int,
    val nama_lengkap: String,
    val nama_panggilan: String,
    val image: Int
)