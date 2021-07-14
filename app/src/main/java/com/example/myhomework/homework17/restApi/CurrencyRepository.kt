package com.example.myhomework.homework17.restApi

import com.example.myhomework.homework17.data.Currency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrencyRepository(
    private val currencyApi: CurrencyApi
) {


  suspend  fun getCurrenciesList(limit: Int, name: String): MutableList<Currency> {

   return  withContext(Dispatchers.IO) {
       currencyApi.getCurrencyList( limit, name).data.map {
           Currency(id = it.id, name = it.name, sign = it.sign)

       }
   }as MutableList<Currency>
  }
}