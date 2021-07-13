package com.example.myhomework.homework17.restApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrencyService {

    private const val BASE_URL = "https://pro-api.coinmarketcap.com/"

    private fun getRefrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCurrencyService(): CurrencyApi = getRefrofit().create(CurrencyApi::class.java)
}