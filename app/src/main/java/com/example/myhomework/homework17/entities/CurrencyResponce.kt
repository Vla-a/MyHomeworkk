package com.example.myhomework.homework17.entities

import com.google.gson.annotations.SerializedName

data class CurrencyResponce(
    @SerializedName("data") val data: MutableList<CurrencyResp>,
    @SerializedName("status") val status: Status,
)
