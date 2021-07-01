package com.example.myhomework.homework13

import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.myhomework.R
import com.example.myhomework.databinding.ActivityHomework13Binding
import com.example.myhomework.homework10.Sweets


@Suppress("DEPRECATION")
class HomeWork13Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework13Binding
     var listSweet: MutableList<Sweets> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework13Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.contFragment.id, MyFragmentSweetsKod(), MyFragmentSweetsKod.TAG)
            .commit()


    }


    fun clickListener(sweet: Sweets) {
        val toast = Toast.makeText(this, "${sweet.marka}, ${sweet.kod}" , Toast.LENGTH_SHORT)
        toast.show()

        FragmentItemSweet().apply {
            arguments = bundleOf("Key" to sweet)


        }

        supportFragmentManager.beginTransaction()
            .replace(binding.cFragment.id, FragmentItemSweet(), FragmentItemSweet.TAG1)
            .addToBackStack(null)
            .commit()

//      val  firstName = sweet!!.marka
//      val  lastName = sweet!!.kod.toString()
//        var details = Call.Details(firstName!!, lastName!!)
//        val viewFragment = MyFragmentSweetsKod()
//        val bundle = Bundle()
//        bundle.putParcelable("Key", details)
//        viewFragment.arguments = bundle
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(binding.cFragment.id, FragmentItemSweet())
//        transaction.commit()
//    }

}

    }
