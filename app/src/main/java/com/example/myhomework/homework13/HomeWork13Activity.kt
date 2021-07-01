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
        val toast = Toast.makeText(this, "${sweet.marka}, ${sweet.kod}", Toast.LENGTH_SHORT)
        toast.show()

        val fragment = FragmentItemSweet().apply {
            arguments = bundleOf("Key" to sweet)
        }

        supportFragmentManager.beginTransaction()
            .replace(binding.cFragment.id, fragment, FragmentItemSweet.TAG1)
            .addToBackStack(null)
            .commit()
    }

}
