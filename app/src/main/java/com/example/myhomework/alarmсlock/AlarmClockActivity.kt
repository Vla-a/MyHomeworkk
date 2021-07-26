package com.example.myhomework.alarmсlock


import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.databinding.ActivityAlarmClockBinding
import java.util.*


class AlarmClockActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmClockBinding
    var min: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlarmClockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSt.setOnClickListener {

            onTimeSet(
                binding.calendarView.dayOfMonth,
                binding.timePicker.currentHour,
                binding.timePicker.currentMinute
            )
        }

        binding.btnStop.setOnClickListener {
            alarmCancel()
        }
    }

    fun alarmStart(calendar: Calendar) {
        val alarm = getSystemService(ALARM_SERVICE) as AlarmManager
        val myAnotherService = Intent(this, AnotherService::class.java)
        val pendingIntent = PendingIntent.getService(
            applicationContext,
            1,
            myAnotherService,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        alarm.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        val notifuBpouk = Intent(this, NotificationBroadcast::class.java)
        val pendingIntent1 = PendingIntent.getBroadcast(
            applicationContext,
            1,
            notifuBpouk,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarm.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent1)
    }

    fun alarmCancel() {
        val alarm = getSystemService(ALARM_SERVICE) as AlarmManager

        val myAnotherService = Intent(this, AnotherService::class.java)
        val pendingIntent = PendingIntent.getService(
            applicationContext,
            0,
            myAnotherService,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        alarm.cancel(pendingIntent)

        val notifuBpouk = Intent(this, NotificationBroadcast::class.java)
        val pendingIntent1 = PendingIntent.getBroadcast(
            applicationContext,
            1,
            notifuBpouk,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        alarm.cancel(pendingIntent1)

        binding.tvTex.text = "будила выключена"
    }

    fun onTimeSet(view: Int, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, view)
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)

        upDateTimeText()
        alarmStart(calendar)
    }

    fun upDateTimeText() {

        min = if (binding.timePicker.currentMinute < 10) {
            "0${binding.timePicker.currentMinute}"
        } else {
            "${binding.timePicker.currentMinute}"
        }
        val timText = "будила поставлена на: ${binding.timePicker.currentHour}:${min}, ${
            binding.calendarView.dayOfMonth
        }.${binding.calendarView.month}.${binding.calendarView.year}"
        binding.tvTex.text = timText
    }
}


