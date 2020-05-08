package com.example.emtwnty.persistence.onDailyFragment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.emtwnty.Model.Daily

/** -Tanggal Pengerjaan:
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Dao
interface DailyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDaily(daily: List<Daily>)

    @Query("select * from daily")
    fun getAllDaily(): List<Daily>
}