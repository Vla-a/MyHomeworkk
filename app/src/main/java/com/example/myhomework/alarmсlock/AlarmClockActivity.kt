package com.example.myhomework.alarmсlock


import android.app.AlarmManager
import android.app.PendingIntent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.databinding.ActivityAlarmClockBinding
import java.util.*
import android.app.Activity
import androidx.annotation.Nullable
import androidx.fragment.app.FragmentManager
import android.R
import android.content.*
import android.widget.Button
import android.widget.FrameLayout

import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.myhomework.homework13.ItemSweetFragment
import com.example.myhomework.homework13.MyFragmentSweetsCode
import org.koin.experimental.builder.getArguments
import java.lang.reflect.Array.newInstance


class AlarmClockActivity : AppCompatActivity() {

    private lateinit var singl: String
    private lateinit var binding: ActivityAlarmClockBinding
    var min: String? = ""


    fun onReceive(intent: Intent?) {
        val ss = intent?.getStringExtra("KEY_FROM_FRAGMENT")
        binding.tvTex.text = ss

    }


    val filter = IntentFilter("BROADCAST_ACTION")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myDialogFragment = MyDialogFragment()
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


            val manager = supportFragmentManager
            myDialogFragment.show(manager, "myDialog")

        }

        onReceive(intent)


            val s:String = chusSingl()
            binding.tvTex.text = s



    }

    fun alarmStart(calendar: Calendar) {

        val serviceIntent = Intent(this, AnotherService::class.java)
        serviceIntent.putExtra("LOS", binding.tvTex.text)
        startService(serviceIntent)

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

        val notifuBpouk = Intent(this, NotificationBroadcast::class.java).apply {

        }
        val pendingIntent1 = PendingIntent.getBroadcast(
            applicationContext,
            1,
            notifuBpouk,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        alarm.cancel(pendingIntent1)




        sendMessage()
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

    private fun upDateTimeText() {

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

    fun chusSingl(): String {

        when {
            binding.activityMainOnclicklistenerAnswer1.isChecked -> {
                singl = "binding.activityMainOnclicklistenerAnswer1.text"
            }
            binding.activityMainOnclicklistenerAnswer2.isChecked -> {
                singl = "binding.activityMainOnclicklistenerAnswer2.text"
            }
            binding.activityMainOnclicklistenerAnswer3.isChecked -> {
                singl = "binding.activityMainOnclicklistenerAnswer3.text"
            }

        }
        return singl
    }

    val WHERE_MY_CAT_ACTION = "ru.alexanderklimov.action.CAT"
    val ALARM_MESSAGE = "Срочно пришлите кота!"

    fun sendMessage() {
        val intent = Intent()
        intent.action = WHERE_MY_CAT_ACTION
        intent.putExtra("ru.alexanderklimov.broadcast.Message", ALARM_MESSAGE)
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        sendBroadcast(intent)
    }


}
