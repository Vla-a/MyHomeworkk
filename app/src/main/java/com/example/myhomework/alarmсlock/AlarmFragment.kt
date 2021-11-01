package com.example.myhomework.alarmсlock

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.myhomework.R
import com.example.myhomework.databinding.FragmentAlarmBinding
import com.example.myhomework.databinding.FragmentItemSweetBinding

class AlarmFragment : Fragment(){

    private lateinit var singl: String
    var binding: FragmentAlarmBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentAlarmBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bandle = Bundle()
        val sag = chusSingl()
     bandle.putString("RER", sag)
        sendMessage()
}
    fun chusSingl(): String {

        when {
            binding!!.chip1.isChecked -> {
                singl = "binding.activityMainOnclicklistenerAnswer1.text"
            }
            binding!!.chip1.isChecked -> {
                singl = "binding.activityMainOnclicklistenerAnswer2.text"
            }
            binding!!.chip1.isChecked -> {
                singl = "binding.activityMainOnclicklistenerAnswer3.text"
            }

        }
        return singl
    }

    val WHERE_MY_CAT_ACTION = "ru.alexanderklimov.action.CAT"
    val ALARM_MESSAGE = "Срочно пришлите кота!"

    fun sendMessage() {
        val intent = Intent()
        intent.action = WHERE_MY_CAT_ACTION
        intent.putExtra("ru.alexanderklimov.broadcast.Message", ALARM_MESSAGE)
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
//        sendBroadcast(intent)
    }

}