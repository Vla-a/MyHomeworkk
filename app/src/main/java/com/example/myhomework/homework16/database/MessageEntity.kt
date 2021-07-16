package com.example.myhomework.homework16.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "massage_table")
class MessageEntity(
     @PrimaryKey val message: String,
     val date: String
)