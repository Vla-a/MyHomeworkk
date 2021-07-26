package com.example.myhomework.widget.data



import android.os.Parcel
import android.os.Parcelable

data class MyWeather(
    val temperature: String,
    val description: String,
    val windSpeed: String,
    val windDirection: String,
    val cityName: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(temperature)
        parcel.writeString(description)
        parcel.writeString(windSpeed)
        parcel.writeString(windDirection)
        parcel.writeString(cityName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyWeather> {
        override fun createFromParcel(parcel: Parcel): MyWeather {
            return MyWeather(parcel)
        }

        override fun newArray(size: Int): Array<MyWeather?> {
            return arrayOfNulls(size)
        }
    }
}