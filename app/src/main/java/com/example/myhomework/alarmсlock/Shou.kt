package com.example.myhomework.alarmсlock

interface Shou {
    abstract val BROADCAST_ACTION: String
    abstract val KEY_FROM_FRAGMENT: Any

    fun remov(name: String?)
}