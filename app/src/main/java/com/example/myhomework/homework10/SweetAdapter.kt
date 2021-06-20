package com.example.myhomework.homework10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomework.R

class SweetAdapter(
    private val sweetList: MutableList<Sweets>
) : RecyclerView.Adapter<SweetAdapter.SweetViewHolder>() {

    override fun getItemCount(): Int = sweetList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_sweet, parent, false)
        return SweetViewHolder(view)
    }

    override fun onBindViewHolder(holder: SweetViewHolder, position: Int) {
        holder.bind(sweetList[position])
    }

    class SweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvMarka: TextView = itemView.findViewById(R.id.tv_marka)
        private val tvKod: TextView = itemView.findViewById(R.id.tv_kod)

        fun bind(item: Sweets) {
            tvMarka.text = item.marka
            tvKod.text = item.kod.toString()
        }
    }
}