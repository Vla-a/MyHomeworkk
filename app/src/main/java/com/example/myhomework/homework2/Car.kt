package com.example.myhomework.homework2

class Car (
    val marka: String = "lada",
    var color: String = "black",
    val engineCapacity: Double = 1.6,
    var stateNumber: String? = null
    )
    {

        fun getCar(): String {


            var stateNumber = stateNumber ?: "transit"

            var myCar: String =
                "specifications саr: marka - $marka, color - $color, engineCapacity - $engineCapacity, stateNumber - $stateNumber"
            return myCar
        }
    }