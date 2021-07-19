package com.example.myhomework.homework17

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhomework.homework17.data.Currency
import com.example.myhomework.homework17.restApi.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent


class Homework17ViewModel(
    private val currencyRepository: CurrencyRepository
) : ViewModel() {


    val currencyLiveData: MutableLiveData<MutableList<Currency>> = MutableLiveData()

    init {
        viewModelScope.launch {
            currencyLiveData.value = currencyRepository.getCurrenciesList()
        }
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

//class HomeWork17ViewModelFactory(
//    private val currencyRepository: CurrencyRepository
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return Homework17ViewModel(currencyRepository) as T
//    }
//}