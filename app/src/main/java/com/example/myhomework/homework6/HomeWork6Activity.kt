package com.example.myhomework.homework6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomework.R
import java.util.ArrayList

//class HomeWork6Activity: AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_homework6)
//    }

//}

class HomeWork6Activity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var mAdapter: RecyclerViewAdapter? = null
    var stringArrayList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework6)
        recyclerView = findViewById(R.id.recyclerView)
        populateRecyclerView()
    }

    private fun populateRecyclerView() {
        stringArrayList.add("Item 1")
        stringArrayList.add("Item 2")
        stringArrayList.add("Item 3")
        stringArrayList.add("Item 4")
        stringArrayList.add("Item 5")
        stringArrayList.add("Item 6")
        stringArrayList.add("Item 7")
        stringArrayList.add("Item 8")
        stringArrayList.add("Item 9")
        stringArrayList.add("Item 10")
        mAdapter = RecyclerViewAdapter(stringArrayList)
        val callback: ItemTouchHelper.Callback = ItemMoveCallback(mAdapter!!)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)
        recyclerView!!.adapter = mAdapter
    }
}