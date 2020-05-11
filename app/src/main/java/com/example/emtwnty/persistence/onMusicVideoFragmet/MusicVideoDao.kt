package com.example.emtwnty.persistence.onMusicVideoFragmet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/** -Tanggal Pengerjaan:
 *  - 11 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Dao
interface MusicVideoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMusivFav(musicVideo: List<MusicVideoEntity>)
    @Query("select * from musicVideo")
    fun getAllDataMusicVideo(): List<MusicVideoEntity>
}