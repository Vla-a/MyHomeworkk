package com.example.myhomework.homework10


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomework.databinding.ActivityHomework10Binding
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


class HomeWork10Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework10Binding
    private var listSweet: MutableList<Sweets> = mutableListOf()
    private val myViewModel: Homework10ViewModel by viewModels()
    val adapter = SweetAdapter(mutableListOf())

    val drapAndDrop = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, 0 ){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {

            val fromPosition = viewHolder.adapterPosition
            val toPosition =  target.adapterPosition

            Collections.swap(listSweet, fromPosition, toPosition)
            adapter.notifyItemMoved(fromPosition, toPosition)
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sweetAdapter = SweetAdapter(listSweet)
        drapAndDrop.attachToRecyclerView(binding.rvSweet)

        with(binding.rvSweet) {
            layoutManager = GridLayoutManager(
                context,
                Utility.calculateNoOfColumns(context, 180f)
            )
            binding.rvSweet?.adapter = sweetAdapter
        }

        myViewModel.sweetLiveData.observe(this, Observer{
            sweetAdapter.update(it)
        })
    }
}