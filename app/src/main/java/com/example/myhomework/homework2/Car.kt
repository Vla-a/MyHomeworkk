package com.example.myhomework.homework2

class Car (
    val marka: String,
    var color: String = "black",
    val engineCapacity: Double,
    var stateNumber: String? = null
    )
    {
        fun getCar(): String {

            var myCar: String =
                "specifications саr: marka - $marka, color - $color, engineCapacity - $engineCapacity, stateNumber - ${stateNumber ?: "transit"}"
            return myCar
        }
    }