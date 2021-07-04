package com.example.myhomework.homework13

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.myhomework.databinding.ActivityHomework13Binding
import com.example.myhomework.homework10.Sweets
import com.example.myhomework.sharedprefs.SharedPrefsKeys.PREFS_BRAND_KEY
import com.example.myhomework.sharedprefs.SharedPrefsKeys.PREFS_KEY
import com.example.myhomework.sharedprefs.SharedPrefsKeys.PREFS_KOD_KEY
import com.example.myhomework.sharedprefs.SharedPrefsUtils


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

//        val toastBrand = SharedPrefsUtils.sharedPrefs.getString(PREFS_BRAND_KEY, "NO VALUES")
//        val toastKod = SharedPrefsUtils.sharedPrefs.getString(PREFS_KOD_KEY, "NO VALUES")
        val toastBrand =
            getSharedPreferences(PREFS_KEY, MODE_PRIVATE).getString(PREFS_BRAND_KEY, "NO VALUES")
        val toastKod =
            getSharedPreferences(PREFS_KEY, MODE_PRIVATE).getString(PREFS_KOD_KEY, "NO VALUES")
        val toast = Toast.makeText(this, "$toastBrand, $toastKod", Toast.LENGTH_SHORT)
        toast.show()

    }

    fun clickListener(sweet: Sweets) {
//        val toast = Toast.makeText(this, "${sweet.brand}, ${sweet.kod}", Toast.LENGTH_SHORT)
//        toast.show()

        val sharedPreferences = getSharedPreferences(PREFS_KEY, MODE_PRIVATE)
        sharedPreferences.edit().putString(PREFS_BRAND_KEY, sweet.brand).apply()
        sharedPreferences.edit().putString(PREFS_KOD_KEY, sweet.kod.toString()).apply()


//        SharedPrefsUtils.putString(PREFS_BRAND_KEY, sweet.brand)
//        SharedPrefsUtils.putString(PREFS_KOD_KEY, sweet.kod.toString())

        val fragment = ItemSweetFragment().apply {
            arguments = bundleOf(MyFragmentSweetsKod.KEY to sweet)
        }

        supportFragmentManager.beginTransaction()
            .replace(binding.cFragment.id, fragment, ItemSweetFragment.TAG1)
            .addToBackStack(null)
            .commit()
    }
}
