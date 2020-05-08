package com.example.emtwnty.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.emtwnty.Model.Daily
import com.example.emtwnty.persistence.onDailyFragment.DailyDao
import com.example.emtwnty.persistence.onDailyFragment.FriendsList
import com.example.emtwnty.persistence.onDailyFragment.FriendsListDao

/** -Tanggal Pengerjaan:
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Database(entities = [FriendsList::class,Daily::class],version = 2)
abstract class EmDatabase:RoomDatabase() {

    abstract fun friendsListDao(): FriendsListDao
    abstract fun dailyDaon(): DailyDao

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