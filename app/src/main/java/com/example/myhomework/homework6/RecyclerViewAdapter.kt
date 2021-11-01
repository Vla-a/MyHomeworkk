package com.example.myhomework.homework6

import android.R
import android.graphics.Color

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


class RecyclerViewAdapter(private val data: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(),
    ItemMoveCallback.ItemTouchHelperContract {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTitle: TextView
        var rowView: View

        init {
            rowView = itemView
            mTitle = itemView.findViewById(R.id.text1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTitle.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override  fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(data, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(data, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

  override  fun onRowSelected(myViewHolder: MyViewHolder?) {
        myViewHolder!!.rowView.setBackgroundColor(Color.GRAY)
    }

    override fun onRowClear(myViewHolder: MyViewHolder?) {
        myViewHolder!!.rowView.setBackgroundColor(Color.WHITE)
    }
}