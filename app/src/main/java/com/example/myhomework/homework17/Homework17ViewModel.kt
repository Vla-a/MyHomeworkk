package com.example.myhomework.homework17

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myhomework.homework17.data.Currency
import com.example.myhomework.homework17.restApi.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Homework17ViewModel(
    private val currencyRepository: CurrencyRepository
) : ViewModel() {

    val currencyLiveData: MutableLiveData<MutableList<Currency>> = MutableLiveData()
    private var limit: Int = 2
    var name: String = "name"

    init {
        addCount(limit, name)
    }

    fun addCount(limit: Int, name: String) {
        viewModelScope.launch(Dispatchers.Main) {
            val currencyList =
                currencyRepository.getCurrenciesList(
                    limit, name
                )
            currencyLiveData.value = currencyList
        }
    }
}

class HomeWork17ViewModelFactory(
    private val currencyRepository: CurrencyRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Homework17ViewModel(currencyRepository) as T
    }
}