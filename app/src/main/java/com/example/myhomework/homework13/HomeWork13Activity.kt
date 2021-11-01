package com.example.myhomework.homework13

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.myhomework.R
import com.example.myhomework.databinding.ActivityHomework13Binding
import com.example.myhomework.homework10.Sweets
import com.example.myhomework.homework13.sharedprefs.SharedPrefsKeys.PREFS_BRAND_KEY
import com.example.myhomework.homework13.sharedprefs.SharedPrefsKeys.PREFS_CODE_KEY
import com.example.myhomework.homework13.sharedprefs.SharedPrefsUtils
import com.example.myhomework.homework13.sharedprefs.SharedPrefsUtilss


@Suppress("DEPRECATION")
class HomeWork13Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework13Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework13Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.contFragment.id, MyFragmentSweetsCode(), MyFragmentSweetsCode.TAG)
            .commit()

        val toastBrand = SharedPrefsUtils.sharedPrefs.getString(PREFS_BRAND_KEY, resources.getString(
            R.string.no_value))
        val toastCode = SharedPrefsUtils.sharedPrefs.getString(PREFS_CODE_KEY, resources.getString(
            R.string.no_value))

        val toast = Toast.makeText(this, "$toastBrand, $toastCode", Toast.LENGTH_SHORT)
        toast.show()

    }

    fun clickListener(sweet: Sweets) {
//        val toast = Toast.makeText(this, "${sweet.brand}, ${sweet.kod}", Toast.LENGTH_SHORT)
//        toast.show()


        SharedPrefsUtils.putString(PREFS_BRAND_KEY, sweet.brand)
        SharedPrefsUtils.putString(PREFS_CODE_KEY, sweet.code.toString())

        val fragment = ItemSweetFragment().apply {
            arguments = bundleOf(MyFragmentSweetsCode.KEY to sweet)
        }

        supportFragmentManager.beginTransaction()
            .replace(binding.cFragment.id, fragment, ItemSweetFragment.TAG1)
            .addToBackStack(null)
            .commit()
    }
}
