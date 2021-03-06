package com.example.myhomework.homework20

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.annotation.RestrictTo
import com.example.myhomework.homework20.restApi.WeatherRepository
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class UpdateWeatherWidgetService : Service(), KoinComponent {

    private val weatherRepository: WeatherRepository by inject()

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val cityName = SharedPrefsLocationUtils.getLocation()

        if (cityName == null) {
            val activityStartIntent = Intent(this, WeatherLocationActivity::class.java)
            activityStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(activityStartIntent)
            stopSelf()
        } else {
            val weather = runBlocking { weatherRepository.getWeather(cityName) }
            val broadcastIntent = Intent(applicationContext, WeatherWidget::class.java).apply {
                action = WeatherWidget.UPDATE
                putExtra(WeatherWidget.WEATHER_EXTRA_KEY, weather)
            }
            applicationContext.sendBroadcast(broadcastIntent)
            stopSelf()
        }

        return START_NOT_STICKY
    }
}