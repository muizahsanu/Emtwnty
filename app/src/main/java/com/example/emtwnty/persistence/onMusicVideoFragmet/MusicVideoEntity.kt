package com.example.emtwnty.persistence.onMusicVideoFragmet

import androidx.room.Entity
import androidx.room.PrimaryKey

/** -Tanggal Pengerjaan:
 *  - 11 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Entity(tableName = "musicVideo")
data class MusicVideoEntity(
    @PrimaryKey
    val id: Int,
    val judulMusic: String,
    val penyanyi: String,
    val videoUri: String
)