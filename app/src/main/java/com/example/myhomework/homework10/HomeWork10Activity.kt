package com.example.myhomework.homework10


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhomework.databinding.ActivityHomework10Binding


class HomeWork10Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHomework10Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework10Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val sweetAdapter = SweetAdapter(SaveSweetsList().result())

        binding.rvSweet?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvSweet?.adapter = sweetAdapter
    }
}