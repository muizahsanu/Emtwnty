package com.example.emtwnty.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/** -Tanggal Pengerjaan:
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  - 10 mei 2020
 *  - 11 mei 2020
 *  - 15 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Database(entities = [
    FriendsList::class,
    Daily::class,
    GalleryEntity::class,
    MusicVideoEntity::class,
    ProfileEntity::class],version = 5)

abstract class EmDatabase:RoomDatabase() {

    abstract fun friendsListDao(): FriendsListDao
    abstract fun dailyDaon(): DailyDao
    abstract fun galleryDao(): GalleryDao
    abstract fun musicVideoDao(): MusicVideoDao
    abstract fun profileDao(): ProfileDao

    companion object{
        @Volatile
        private var INSTANCE: EmDatabase? = null

        fun getInstance(context: Context): EmDatabase =
            INSTANCE?: synchronized(this){
                INSTANCE?: buildDatabase(context).also{INSTANCE = it}
            }

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                EmDatabase::class.java,"emDb").fallbackToDestructiveMigration().build()
    }
}