package com.example.myhomework.alarmсlock

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.example.myhomework.R


class AnotherService : Service() {

    lateinit var  mp: MediaPlayer


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        var sew:Int = R.raw.trek
        val s = intent?.getStringExtra("LOS")
        if(s == "binding.activityMainOnclicklistenerAnswer1.text"){
            sew =  R.raw.burito
        } else if(s == "binding.activityMainOnclicklistenerAnswer2.text"){
            sew =  R.raw.trek
        }
        //player
        mp = MediaPlayer.create(this,sew)
        mp.start()


        //Toast
        Toast.makeText(applicationContext, s, Toast.LENGTH_LONG ).show()

        return  START_NOT_STICKY
    }

}
