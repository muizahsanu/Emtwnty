package com.example.emtwnty.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FriendsListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDataFriendsList(friendsList: List<FriendsList>)

    @Query("select * from friendslist")
    fun getAllDataFriendsList(): List<FriendsList>
}