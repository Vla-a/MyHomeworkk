package com.example.myhomework.homework16

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhomework.MySuperApp
import com.example.myhomework.R
import com.example.myhomework.databinding.ActivityHomework15Binding


class HomeWork15Activity : AppCompatActivity() {

    private var listMessage: MutableList<Message> = mutableListOf()
    private lateinit var binding: ActivityHomework15Binding
    private val myViewModel: HomeWork15ViewModel by viewModels {
        HomeWork15ViewModelFactory((application as MySuperApp).messageRepository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val messageAdapter = MessageAdapter(listMessage) { clickListener(it) }

        binding = ActivityHomework15Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMessage.setOnClickListener {

            with(binding.editTextMessage) {
                myViewModel.addMessageToDatabase(text.toString())
                setText("")
            }

//binding.editTextMessage.apply {
//    myViewModel.addMessageToDatabase(text.toString())
//    setText("")
//}
        }


        binding.rvMessage?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMessage?.adapter = messageAdapter

        myViewModel.messageListLiveData.observe(this, Observer {
            messageAdapter.update(it as MutableList<Message>)
        })

        val horizontalDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        horizontalDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.line_divider)!!)
        binding.rvMessage.addItemDecoration(horizontalDecoration)
    }

    fun clickListener(message: Message) {

        myViewModel.deleteMessage(message)
    }
}