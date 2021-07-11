package com.example.myhomework.homework15.database

import androidx.room.Entity

@Entity(tableName = "massage_table", primaryKeys = ["message"])
class MessageEntity(
    val message: String,
    val date: String
)
