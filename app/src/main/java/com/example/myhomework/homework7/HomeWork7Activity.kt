package com.example.myhomework.homework7


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myhomework.databinding.ActivityHomework7Binding


class HomeWork7Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework7Binding
    private var counter = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7Binding.inflate(layoutInflater)
        setContentView(binding.root)

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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(TIMER, counter)
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val LOGIN = "LOGIN"
        const val PASSWORD = "PASSWORD"
        const val TIMER = "TIMER"
        const val NAME = "NAME"
    }
}