package com.example.myhomework.homework17.restApi




import com.example.myhomework.BuildConfig
import com.example.myhomework.homework17.entities.CurrencyResponce
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CurrencyApi {

    @Headers("X-CMC_PRO_API_KEY: ${BuildConfig.API_KEY}" )
    @GET("v1/fiat/map")
   suspend fun getCurrencyList(
      @Query("limit") limit: Int,
        @Query("sort") name: String
   ): CurrencyResponce
}