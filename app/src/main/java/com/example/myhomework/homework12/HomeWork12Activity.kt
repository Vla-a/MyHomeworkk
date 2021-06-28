package com.example.myhomework.homework12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
            supportFragmentManager.beginTransaction()
                .replace(binding.contenerFragment.id, newFragment())
                .commit()
        }
    }

    private fun newFragment(): Fragment {

        when (counter) {
            1 -> return MyFragment1()
            2 -> return MyFragment2()
            3 -> return MyFragment3()
            4 -> return MyFragment4()
            5 -> {
                counter = 0
                return MyFragment5()
            }
        }
        return Fragment()
    }
}





