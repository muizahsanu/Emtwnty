package com.example.emtwnty.persistence.onGalleryFragment

import androidx.room.Entity
import androidx.room.PrimaryKey

/** -Tanggal Pengerjaan:
 *  - 9 mei 2020
 *  - 10 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Entity(tableName = "galleryEntity")
data class GalleryEntity(
    @PrimaryKey
    val id: Int,
    val image: String
)