package com.example.myhomework

import android.app.Application
import com.example.myhomework.homework16.HomeWork15ViewModel
import com.example.myhomework.homework16.database.DatabaseConstructor
import com.example.myhomework.homework16.database.MessageDatabase
import com.example.myhomework.homework16.database.MessageRepository
import com.example.myhomework.homework17.Homework17ViewModel
import com.example.myhomework.homework17.restApi.CurrencyRepository
import com.example.myhomework.homework17.restApi.CurrencyService
import com.example.myhomework.homework13.sharedprefs.SharedPrefsKeys
import com.example.myhomework.homework13.sharedprefs.SharedPrefsUtils
import com.example.myhomework.widget.SharedPrefsLocationUtils
import com.example.myhomework.widget.WeatherActivity
import com.example.myhomework.widget.WeatherViewModel
import com.example.myhomework.widget.restAPI.WeatherRepository
import com.example.myhomework.widget.restAPI.WeatherService
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


class MySuperApp : Application() {

//    OLD
//    private val messageDatabase: MessageDatabase by lazy {
//        Room.databaseBuilder(this, MessageDatabase::class.java, "message_database").build()
//    }
//    private val messageDao: MessageDao by lazy { messageDatabase.MessageDao() }
//
//    val messageRepository: MessageRepository by lazy { MessageRepository(messageDao) }
//
//    val currencyRepository: CurrencyRepository by lazy {
//        CurrencyRepository(CurrencyService.getCurrencyService())
//    }



    override fun onCreate() {
        super.onCreate()

        SharedPrefsUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsKeys.PREFS_KEY, MODE_PRIVATE)

        SharedPrefsLocationUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsLocationUtils.PREFS_KEY,
                MODE_PRIVATE)

        startKoin {
            androidContext(this@MySuperApp)
            modules(listOf(repositoryModule, viewModels, currencyApi, storageModule))
        }
    }

    private val viewModels = module {
        viewModel { Homework17ViewModel(get()) }
        viewModel { HomeWork15ViewModel(get()) }
        viewModel { WeatherViewModel(get()) }
    }

    private val repositoryModule = module {  //создаем репозитории
        factory { CurrencyRepository(get()) }
        factory { MessageRepository(get()) }
        factory { WeatherRepository(get()) }
    }

    private val currencyApi = module {
        factory { CurrencyService.getCurrencyService() }
        factory { WeatherService.getWeatherService() }
    }

    private val storageModule = module {
        single { DatabaseConstructor.create(get()) }  //создаем синглтон базы данных
        factory { get<MessageDatabase>().MessageDao() } //предоставляем доступ для конкретной Dao (в нашем случае MessageDao)
    }
}