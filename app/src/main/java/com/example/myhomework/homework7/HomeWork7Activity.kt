package com.example.myhomework.homework7


import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myhomework.R
import com.example.myhomework.databinding.ActivityHomework7Binding
import com.example.myhomework.homework13.sharedprefs.SharedPrefsKeyss
import com.example.myhomework.homework13.sharedprefs.SharedPrefsUtilss


class HomeWork7Activity : AppCompatActivity() {

    var count: Int = 0
    private lateinit var binding: ActivityHomework7Binding
    private var counter = 10
    private var rington: Ringtone? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ASwitch.isChecked = SharedPrefsUtilss.sharedPrefs.getBoolean(SharedPrefsKeyss.KEY, false)


        //рингтон
        val notificUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        rington = RingtoneManager.getRingtone(this, notificUri)
        if (rington == null) {
            val notificUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            rington = RingtoneManager.getRingtone(this, notificUri)
        }
        binding.ivR.setOnClickListener {
            when(count) {
                0-> { count++
                    rington?.play()
                binding.ivR.setImageResource(R.drawable.ic_baseline_chat_bubble_24)}
                1-> {
                    count = 0
                    rington?.stop()
                    binding.ivR.setImageResource(R.drawable.ic_baseline_chat_bubble_outline_24)
                }
            }
        }


        binding.bCliK?.setOnClickListener {

            binding.tvTextView?.text = (counter - 1).toString()
            counter--
            if (counter <= 0) {
                binding.tvTextView.visibility = View.GONE
                binding.inputLogin.visibility = View.VISIBLE
                binding.inputPassword.visibility = View.VISIBLE
                binding.bCliK.text = "enter"
                binding.bCliK.setOnClickListener {
                    startActivity(
                        Intent(this, HomeWork7t2Activity::class.java).apply {
                            putExtra(LOGIN, binding.etLogin.text.toString())
                            putExtra(PASSWORD, binding.etPassword.text.toString())
                        })
                }
            }
        }
        savedInstanceState?.let {
            counter = it.getInt(TIMER)
            binding.tvTextView.text = counter.toString()
        }
        Glide
            .with(this)
            .load("https://img.fonwall.ru/o/45/zakat-more-gorizont-otrajenie.jpg")
            .into(binding.ivPicture)
    }

    override fun onPause() {
        super.onPause()
        SharedPrefsUtilss.putString(SharedPrefsKeyss.KEY, binding.ASwitch.isChecked)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(TIMER, counter)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        rington?.stop()
    }


    companion object {
        const val LOGIN = "LOGIN"
        const val PASSWORD = "PASSWORD"
        const val TIMER = "TIMER"
        const val NAME = "NAME"
    }
}
