package com.example.myhomework.homework17

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhomework.MySuperApp
import com.example.myhomework.databinding.ActivityHomework17Binding
import com.example.myhomework.homework17.data.Currency
import com.example.myhomework.homework17.data.CurrencyAdapter


class HomeWork17Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework17Binding
    private val myViewModel: Homework17ViewModel by viewModels {
        HomeWork17ViewModelFactory((application as MySuperApp).currencyRepository)
    }

    private  val currencyAdapter: CurrencyAdapter = CurrencyAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomework17Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with( binding.rvCurrency){
            adapter = currencyAdapter
            layoutManager = LinearLayoutManager(this@HomeWork17Activity)
        }



        binding.btnEnter.setOnClickListener {

            myViewModel.currencyLiveData.observe(this, {
                currencyAdapter.update(it)
            })

            with(binding.editTextLimit) {
                myViewModel.addCount(text.toString().toInt())
                setText("${text.toString()}")
                Log.e("ddd", "edittext =$text")
            }
//            binding.editTextLimit.visibility = View.GONE
            if (binding.checkBox2.isChecked) {
               myViewModel.addString(binding.checkBox2.text.toString())
            }else if(binding.checkBox1.isChecked) {
                myViewModel.addString(binding.checkBox1.text.toString())
            }


        }


    }
}