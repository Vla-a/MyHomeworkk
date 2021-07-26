package com.example.myhomework.homework20.restApi


import com.example.myhomework.BuildConfig
import com.example.myhomework.homework20.entities.WeatherResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") key: String = BuildConfig.API_KEY2,
        @Query("units") units: String = WeatherApiService.UNITS_METRIC
    ): Response<WeatherResponseEntity>
}