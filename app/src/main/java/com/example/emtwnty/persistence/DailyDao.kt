package com.example.emtwnty.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.emtwnty.Model.DailyActivty


@Dao
interface DailyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDaily(daily: List<DailyActivty>)

    @Query("select * from daily")
    fun getAllDaily(): List<DailyActivty>
}