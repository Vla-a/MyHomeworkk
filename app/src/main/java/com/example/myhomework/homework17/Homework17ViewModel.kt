package com.example.myhomework.homework17

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myhomework.homework17.data.Currency
import com.example.myhomework.homework17.restApi.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Homework17ViewModel(
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    val currencyLiveData: MutableLiveData<List<Currency>> = MutableLiveData()
    var lim: Int = 20
var nam : String = ""

    init {

        viewModelScope.launch(Dispatchers.Main) {
         val currencyList =
             currencyRepository.getCurrenciesList(addCount(lim), addString(nam)
             )

            currencyLiveData.value = currencyList
            Log.e("ddd", "limwww = $lim")
        }
    }

    fun addCount(limit: Int): Int {
        Log.e("ddd", "limit = $limit")
        lim = limit
        Log.e("ddd", "lim = $lim")
        return lim
    }
    fun addString(name: String):String {
        Log.e("ddd", "name = $name")
        nam = name
        Log.e("ddd", "nam = $nam")
        return nam
    }
}

class HomeWork17ViewModelFactory(
    private val currencyRepository: CurrencyRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Homework17ViewModel(currencyRepository) as T
    }
}