package com.example.myhomework.widget

import androidx.lifecycle.ViewModel
import com.example.myhomework.widget.data.MyWeather
import com.example.myhomework.widget.restAPI.WeatherRepository
import kotlinx.coroutines.runBlocking

class WeatherViewModel (private val weatherRepository: WeatherRepository) : ViewModel() {


    fun getWeather(cityName: String): MyWeather? =
        runBlocking { weatherRepository.getWeather(cityName) }

    fun hasCity(cityName: String): Boolean = runBlocking { weatherRepository.hasCity(cityName) }

    fun saveCity(cityName: String) = SharedPrefsLocationUtils.putLocation(cityName)
}







