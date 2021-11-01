package com.example.myhomework.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.databinding.ActivitiCustomViewBinding

class CustomViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivitiCustomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitiCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}