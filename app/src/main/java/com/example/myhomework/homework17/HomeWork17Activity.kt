package com.example.myhomework.homework17

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhomework.databinding.ActivityHomework17Binding
import com.example.myhomework.homework17.data.CurrencyAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class HomeWork17Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework17Binding
    private val myViewModel: Homework17ViewModel by viewModel()
//        HomeWork17ViewModelFactory((application as MySuperApp).currencyRepository)
//    }

    private val currencyAdapter: CurrencyAdapter = CurrencyAdapter()
    private lateinit var sortName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityHomework17Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.rvCurrency) {
            adapter = currencyAdapter
            layoutManager = LinearLayoutManager(this@HomeWork17Activity)
        }

        myViewModel.currencyLiveData.observe(this, {
            it?.let {
                currencyAdapter.update(it)
            }
        })

        binding.btnEnter.setOnClickListener {



            sortName = if (binding.checkBox2.isChecked) {
               binding.checkBox2.text.toString()
            } else {
               binding.checkBox1.text.toString()
            }

            with(binding.editTextLimit) {
                myViewModel.addCount(text.toString().toInt(), sortName)
            }
        }
    }
}