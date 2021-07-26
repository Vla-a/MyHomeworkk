package com.example.myhomework.widget.restAPI

import com.example.myhomework.BuildConfig
import com.example.myhomework.widget.entities.WeaterGeneral
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface WeatherApi {

//    @Headers("x-api-key: ${BuildConfig.API_KEY2}" )


    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String = "Minsk",
        @Query("appid") key: String = BuildConfig.API_KEY2,
        @Query("units") units: String = WeatherService.UNITS_METRIC
    ): Response<WeaterGeneral>

}





