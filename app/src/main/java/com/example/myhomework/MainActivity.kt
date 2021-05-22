package com.example.myhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhomework.homework2.SixCars
import com.example.myhomework.homework3.Animal
import com.example.myhomework.homework3.Dog
import com.example.myhomework.homework3.Elephant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SixCars.createCar()

        val bob = Dog("Bob", 43)
        println("${bob.name} пробежал за ${bob.getTime()}")

        val rok = Elephant("Pok", 89)
        println("${rok.name} пробежал за ${rok.getTime()}")

    }
}