package com.example.myhomework.homework7


import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.R

class HomeWork7Activity : AppCompatActivity() {

    private lateinit var click: Button
    private lateinit var text: TextView
    private lateinit var password: EditText
    private lateinit var login: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework7)

       click = findViewById(R.id.b_cliсk)
        password = findViewById(R.id.et_password)
        login = findViewById(R.id.et_login)
        text = findViewById(R.id.tv_textView)
        val intent = Intent(this, HomeWork7t2Activity::class.java)

        val timer = object  :CountDownTimer(10000,1000){

            override fun onTick(millisUntilFinished: Long) {
                text.text = "second : ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                text.visibility = View.GONE
                login.visibility = View.VISIBLE
                password.visibility = View.VISIBLE
                click.text = "enter"
                click.setOnClickListener{
                startActivity(
                    intent.apply {
                        putExtra(LOGIN, login.text.toString())
                        putExtra(PASSWORD, password.text.toString())
                    } )
                }
            }
        }
        click.setOnClickListener {
            timer.start()
        }

    }
    companion object{
        const val LOGIN = "LOGIN"
        const val PASSWORD = "PASSWORD"
    }
}