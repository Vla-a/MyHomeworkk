package com.example.myhomework

import android.app.Application
import androidx.room.Room
import com.example.myhomework.homework16.HomeWork15ViewModel
import com.example.myhomework.homework16.database.MessageDao
import com.example.myhomework.homework16.database.MessageDatabase
import com.example.myhomework.homework16.database.MessageRepository
import com.example.myhomework.homework17.restApi.CurrencyRepository
import com.example.myhomework.homework17.restApi.CurrencyService
import com.example.myhomework.sharedprefs.SharedPrefsKeys
import com.example.myhomework.sharedprefs.SharedPrefsUtils
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


class MySuperApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(this, MessageDatabase::class.java, "message_database").build()
    }
    private val messageDao: MessageDao by lazy { messageDatabase.MessageDao() }

    val messageRepository: MessageRepository by lazy { MessageRepository(messageDao) }

    val currencyRepository: CurrencyRepository by lazy {
        CurrencyRepository(CurrencyService.getCurrencyService())
    }
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MySuperApp)
            modules(listOf(repositoryModule, viewModels))
        }

        SharedPrefsUtils.sharedPrefs =
            applicationContext.getSharedPreferences(SharedPrefsKeys.PREFS_KEY, MODE_PRIVATE)
    }

    private val repositoryModule = module {  //создаем репозитории
        factory { CurrencyRepository(get()) }
        factory { MessageRepository(get()) }
    }

    private val viewModels = module {
        viewModel { HomeWork15ViewModel(get()) }

    }
}