package com.example.myhomework.homework2

object SixCars {


    fun createCar(){

        val car1 = Car("mersedes", "red", 2.6, "FT-121" )
        val car2 = Car("lada", "black", 1.6, "FT-122" )
        val car3 = Car("reno", "brown", 2.5,  )
        val car4 = Car("pego", "pink", 2.9, "FT-123")
        val car5 = Car("nissan", "red", 2.0, "FT-124" )
        val car6 = Car("tesla", "yellow", 1.4, "FT-125" )

        println(car1.getCar())
        println(car2.getCar())
        println(car3.getCar())
        println(car4.getCar())
        println(car5.getCar())
        println(car6.getCar())
    }
}