package com.example.myhomework.homework13

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomework.databinding.ItemMyFragmentSweetBinding
import com.example.myhomework.homework10.Sweets


class SweetAdapter2(
    private val sweetList: MutableList<Sweets>,
    private val clickListener: (Sweets) -> Unit
) : RecyclerView.Adapter<SweetAdapter2.Sweet2ViewHolder>() {

    override fun getItemCount(): Int = sweetList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Sweet2ViewHolder {

        return Sweet2ViewHolder(
            ItemMyFragmentSweetBinding.inflate(LayoutInflater.from(parent.context)),
            clickListener
        )
    }

    override fun onBindViewHolder(holder: Sweet2ViewHolder, position: Int) {
        holder.bind(sweetList[position])
    }

    fun update(newSweetList: MutableList<Sweets>) {

        sweetList.clear()
        sweetList.addAll(newSweetList)
        notifyDataSetChanged()
    }

    class Sweet2ViewHolder(
        private val bindingView: ItemMyFragmentSweetBinding,
        private val clickListener: (Sweets) -> Unit
    ) :
        RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Sweets) {
            bindingView.tvMarka2.text = item.brand
            bindingView.tvKod2.text = item.code.toString()

            itemView.setOnClickListener { clickListener(item) }
        }
    }
}

