package com.example.myhomework.homework13

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.myhomework.databinding.ActivityHomework13Binding
import com.example.myhomework.homework10.Sweets


@Suppress("DEPRECATION")
class HomeWork13Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework13Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework13Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.contFragment.id, MyFragmentSweetsKod(), MyFragmentSweetsKod.TAG)
            .commit()
    }

    fun clickListener(sweet: Sweets) {
        val toast = Toast.makeText(this, "${sweet.brand}, ${sweet.kod}", Toast.LENGTH_SHORT)
        toast.show()

        val fragment = ItemSweetFragment().apply {
            arguments = bundleOf(MyFragmentSweetsKod.KEY to sweet)
        }

        supportFragmentManager.beginTransaction()
            .replace(binding.cFragment.id, fragment, ItemSweetFragment.TAG1)
            .addToBackStack(null)
            .commit()
    }

}
