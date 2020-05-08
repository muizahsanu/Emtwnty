package com.example.emtwnty.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FriendsList::class,DailyDao::class],version = 1)
abstract class EmDatabase:RoomDatabase() {

    abstract fun friendsListDao(): FriendsListDao
    abstract fun dailyDao(): DailyDao

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