package com.example.myhomework.homework13

import android.app.Application
import com.example.myhomework.sharedprefs.SharedPrefsKeys
import com.example.myhomework.sharedprefs.SharedPrefsUtils

class MySyperApp : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPrefsUtils.sharedPrefs = applicationContext.getSharedPreferences(SharedPrefsKeys.PREFS_KEY, MODE_PRIVATE)
    }
}