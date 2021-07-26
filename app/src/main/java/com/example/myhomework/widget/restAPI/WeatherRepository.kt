package com.example.myhomework.widget.restAPI

import com.example.myhomework.widget.data.MyWeather
import com.example.myhomework.widget.entities.WeaterGeneral
import kotlin.math.roundToInt

class WeatherRepository (private val weatherApi: WeatherApi) {

    suspend fun getWeather(cityName: String): MyWeather? =
        weatherApi.getWeather(cityName).body()?.toWeather()

    suspend fun hasCity(cityName: String): Boolean = weatherApi.getWeather(cityName).isSuccessful

    private fun WeaterGeneral.toWeather(): MyWeather {
        val temperature = this.main.temp.roundToInt()
        return MyWeather(
            StringBuilder().append(if (temperature >= 0) "+" else "")
                .append(temperature)
                .append("\u2103")
                .toString(),
            this.weather[0].description,
            StringBuilder().append(this.wind.speed).append(" m/s").toString(),
            when (this.wind.deg) {
                in 23..67 -> "NE"
                in 68..112 -> "E"
                in 113..157 -> "SE"
                in 158..202 -> "S"
                in 203..247 -> "SW"
                in 248..292 -> "W"
                in 293..337 -> "NW"
                else -> "N"
            },
            this.name
        )
    }
}