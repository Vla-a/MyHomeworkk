package com.example.myhomework

import android.app.Application
import androidx.room.Room
import com.example.myhomework.homework15.database.MessageDao
import com.example.myhomework.homework15.database.MessageDatabase
import com.example.myhomework.homework15.database.MessageRepositiry
import com.example.myhomework.sharedprefs.SharedPrefsKeys
import com.example.myhomework.sharedprefs.SharedPrefsUtils

class MySuperApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(this, MessageDatabase::class.java, "message_database").build()
    }
    private val messageDao: MessageDao by lazy { messageDatabase.MessageDao() }

    val messageRepository: MessageRepositiry by lazy { MessageRepositiry(messageDao) }
    override fun onCreate() {
        super.onCreate()

        SharedPrefsUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsKeys.PREFS_KEY, MODE_PRIVATE)
    }
}