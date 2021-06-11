package com.example.myhomework.homework7

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myhomework.databinding.ActivityHomework7t2Binding
import com.example.myhomework.homework7.HomeWork7Activity.Companion.LOGIN
import com.example.myhomework.homework7.HomeWork7Activity.Companion.NAME

import com.example.myhomework.homework7.HomeWork7Activity.Companion.PASSWORD

class HomeWork7t2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework7t2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7t2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvNameLogin.text = "Login: ${intent.extras?.getString(LOGIN) ?: "No login"}"
        binding.tvNamePassword.text =
            "Password: ${intent.extras?.getString(PASSWORD) ?: "No password"}"

        binding.btnStop.setOnClickListener {
            finish()
        }
        Glide
            .with(this)
            .load("https://i.ytimg.com/vi/GMonc6hOprA/maxresdefault.jpg")
            .into(binding.ivPicture1)
    }
}