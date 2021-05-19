package com.example.myhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhomework.homework2.Car
import com.example.myhomework.homework2.SixCars

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sas = SixCars.createCar()

       Car()
    }
}