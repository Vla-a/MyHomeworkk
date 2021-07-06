package com.example.myhomework.homework13

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myhomework.homework10.SaveSweetsList
import com.example.myhomework.homework10.Sweets

class MyFragmentSweetsCodeViewModel : ViewModel() {

    val sweetsLiveData2: MutableLiveData<MutableList<Sweets>> = MutableLiveData()

    init {
        getSweetsList()
    }

    private fun getSweetsList() {
        Log.e("aaa", "getSweetsList()")
        sweetsLiveData2.value = SaveSweetsList().result()
    }
}