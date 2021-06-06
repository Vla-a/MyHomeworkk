package com.example.myhomework

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.HomeWork7Activity.Companion.LOGIN
import com.example.myhomework.HomeWork7Activity.Companion.PASSWORD

class `HomeWork7t2Activity` : AppCompatActivity() {

    private lateinit var logi: TextView
    private lateinit var pass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework7t2)

//        val login = intent.extras?.getString(LOGIN)?: "llll"
//        val password = intent.extras?.getString(PASSWORD)?: "uuuuu"
//        Log.e("kkkkk", "$login, $password")

        logi = findViewById(R.id.tv_name_login)
        pass = findViewById(R.id.tv_name_password)

        logi.text = "Login: ${intent.extras?.getString(LOGIN)?: "No login"}"
        pass.text = "Password: ${intent.extras?.getString(PASSWORD)?: "No password"}"


    }
}