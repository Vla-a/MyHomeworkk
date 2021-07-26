package com.example.myhomework.homework20

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.databinding.ActivityWeatherLocationBinding
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherLocationBinding
    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmLocation.setOnClickListener {
            val city = binding.etLocation.text.toString()
            if (viewModel.hasCity(city)) {
                viewModel.saveCity(city)
                this.finish()
            } else {
                Toast.makeText(this, "No such City", Toast.LENGTH_SHORT).show()
                binding.etLocation.text.clear()
            }
        }
    }
}