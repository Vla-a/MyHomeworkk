package com.example.myhomework.homework10


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhomework.databinding.ActivityHomework10Binding


class HomeWork10Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework10Binding
    private var listSweet: MutableList<Sweets> = mutableListOf()
    private val myViewModel: Homework10ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework10Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val sweetAdapter = SweetAdapter(listSweet)

        binding.rvSweet?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvSweet?.adapter = sweetAdapter

        myViewModel.sweetLiveData.observe(this, Observer{
            sweetAdapter.update(it)
        })
    }
}