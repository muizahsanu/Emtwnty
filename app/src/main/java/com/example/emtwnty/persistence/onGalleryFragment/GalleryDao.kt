package com.example.emtwnty.persistence.onGalleryFragment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/** -Tanggal Pengerjaan:
 *  - 9 mei 2020
 *  - 10 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Dao
interface GalleryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGallery(galleryEntity: List<GalleryEntity>)
    @Query("select * from galleryEntity")
    fun getAllGallery(): List<GalleryEntity>
}