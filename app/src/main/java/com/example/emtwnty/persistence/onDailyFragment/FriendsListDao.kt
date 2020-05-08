package com.example.emtwnty.persistence.onDailyFragment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.emtwnty.persistence.onDailyFragment.FriendsList

/** -Tanggal Pengerjaan:
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Dao
interface FriendsListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDataFriendsList(friendsList: List<FriendsList>)

    @Query("select * from friendslist")
    fun getAllDataFriendsList(): List<FriendsList>
}