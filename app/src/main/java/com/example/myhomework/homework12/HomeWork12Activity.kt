package com.example.myhomework.homework12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.R
import com.example.myhomework.databinding.ActivityHomework12Binding


class HomeWork12Activity : AppCompatActivity() {

    private var counter = 0
    private lateinit var binding: ActivityHomework12Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bNewFragment.setOnClickListener {
            counter++

            when (counter) {
                1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contener_fragment, MyFragment1())
                        .commit()
                }
                2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contener_fragment, MyFragment2())
                        .commit()
                }
                3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contener_fragment, MyFragment3())
                        .commit()
                }
                4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contener_fragment, MyFragment4())
                        .commit()
                }
                5 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contener_fragment, MyFragment5())
                        .commit()
                    counter = 0
                }
            }
        }
    }
}






