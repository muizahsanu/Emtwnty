package com.example.emtwnty.Model

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

@Entity(tableName = "daily")
data class Daily(
    @PrimaryKey
    val id: Int,
    val judul_aktivitas: String,
    val waktu_aktivitas: String
)