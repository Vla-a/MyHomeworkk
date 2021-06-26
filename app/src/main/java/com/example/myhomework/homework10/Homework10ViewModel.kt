package com.example.myhomework.homework10

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Homework10ViewModel : ViewModel() {

    val sweetLiveData: MutableLiveData<MutableList<Sweets>> = MutableLiveData()

    init {
        getSweetsList()
    }

    override fun onCleared() {
        super.onCleared()
    }

    private fun getSweetsList() {
        sweetLiveData.value = SaveSweetsList().result()
    }
}



