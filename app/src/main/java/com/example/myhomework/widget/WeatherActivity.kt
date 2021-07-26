package com.example.myhomework.widget

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.R
import com.example.myhomework.databinding.ActivitiWeatherBinding
import org.koin.android.viewmodel.ext.android.viewModel


class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivitiWeatherBinding

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitiWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmLocation.setOnClickListener {
            val city = binding.etLocation.text.toString()
            if (viewModel.hasCity(city)) {
                viewModel.saveCity(city)
//                this.finish()
            } else {
                Toast.makeText(this, "There is no such city", Toast.LENGTH_SHORT).show()
                binding.etLocation.text.clear()
            }
        }
    }
}
