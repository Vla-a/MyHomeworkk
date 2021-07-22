package com.example.myhomework.homework7


import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myhomework.databinding.ActivityHomework7Binding


class HomeWork7Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework7Binding
    private var counter = 10
    private var rington: Ringtone? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bCliK?.setOnClickListener {

            val notificUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            rington = RingtoneManager.getRingtone(this, notificUri)
            if (rington == null) {
                val notificUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
                rington = RingtoneManager.getRingtone(this, notificUri)
            }
            if (rington != null) {
                rington?.play()
            }

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