package com.example.emtwnty.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/** -Tanggal Pengerjaan:
 *  - 14 mei 2020
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

@Dao
interface FriendsListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDataFriendsList(friendsList: List<FriendsList>)

    @Query("select * from friendslist")
    fun getAllDataFriendsList(): List<FriendsList>
}

@Dao
interface GalleryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGallery(galleryEntity: List<GalleryEntity>)
    @Query("select * from galleryEntity")
    fun getAllGallery(): List<GalleryEntity>
}

@Dao
interface MusicVideoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMusivFav(musicVideo: List<MusicVideoEntity>)
    @Query("select * from musicVideo")
    fun getAllDataMusicVideo(): List<MusicVideoEntity>
}