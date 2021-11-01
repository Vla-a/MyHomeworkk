package com.example.myhomework.alarmсlock

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.myhomework.R
import kotlinx.serialization.json.Json.Default.context
import java.util.*
import kotlin.properties.Delegates
import android.widget.Toast





class NotificationBroadcast : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(
            context, "Обнаружено сообщение: " +
                    intent.getStringExtra("ru.alexanderklimov.broadcast.Message"),
            Toast.LENGTH_LONG
        ).show()

        // notification
        try {
            val contentIntent = PendingIntent.getActivity(
                context, 0,
                Intent(context, NotificationBroadcast::class.java), 0
            )

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createChannel(notificationManager)
            }

            val builder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                .setContentTitle("Hi, Владимир!")
                .setContentText("Пора вставать!!!")
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setDefaults(Notification.DEFAULT_SOUND)

                .setAutoCancel(true)
            notificationManager.notify(0, builder.build())
        } catch (e: Exception) {
            println("===============================")
            e.printStackTrace()
            println("===============================")
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(notificationManager: NotificationManager) {
        if (notificationManager.getNotificationChannel(NOTIFICATION_CHANNEL) == null) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL,
                NOTIFICATION_CHANNEL,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

    }
    companion object {

        private const val NOTIFICATION_CHANNEL = "PLANNER_APP_NOTIFICATION_CHANNEL"
        const val ACTION_POSTPONE = "PLANNER_APP_NOTIFICATION_POSTPONE"
    }
}
