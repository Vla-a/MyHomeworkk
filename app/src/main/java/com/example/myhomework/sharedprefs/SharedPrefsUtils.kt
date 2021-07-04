package com.example.myhomework.sharedprefs

import android.content.SharedPreferences


object SharedPrefsUtils {

    lateinit var sharedPrefs: SharedPreferences

    fun putString(key: String, value: String){

        sharedPrefs.edit().putString(key, value).apply()
    }
}