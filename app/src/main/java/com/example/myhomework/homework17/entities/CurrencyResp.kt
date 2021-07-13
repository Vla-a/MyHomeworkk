package com.example.myhomework.homework17.entities

import com.google.gson.annotations.SerializedName

data class CurrencyResp(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sign") val sign: String,
    @SerializedName("symbol") val symbol: String
)
