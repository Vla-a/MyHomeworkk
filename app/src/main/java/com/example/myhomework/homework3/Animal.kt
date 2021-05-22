package com.example.myhomework.homework3

open class Animal(private val speed: Int) {


    fun getTime(): Double {
        return WAY.toDouble() / speed.toDouble()
    }

    companion object{
       private const val WAY = 1080
    }

}