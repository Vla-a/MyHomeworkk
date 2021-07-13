package com.example.myhomework.homework16.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MessageEntity::class], version = 1)
abstract class MessageDatabase : RoomDatabase() {

    abstract fun MessageDao(): MessageDao
}