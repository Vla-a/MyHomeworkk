package com.example.myhomework.homework13

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.myhomework.databinding.ItemMyFragmentSweetBinding
import com.example.myhomework.homework10.SaveSweetsList
import com.example.myhomework.homework10.Sweets


class SweetAdapter2(
    private val sweetList: MutableList<Sweets>,
    private  val clickListener: (Sweets) -> Unit
) : RecyclerView.Adapter<SweetAdapter2.Sweet2ViewHolder>() {





    override fun getItemCount(): Int = sweetList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Sweet2ViewHolder {

        return Sweet2ViewHolder(
            ItemMyFragmentSweetBinding.inflate(LayoutInflater.from(parent.context)),
            clickListener)
    }

    override fun onBindViewHolder(holder: Sweet2ViewHolder, position: Int) {
        holder.bind(sweetList[position])

//        holder.bindingView.tvKod2 .setOnClickListener{
//
//                holder.bindingView.tvMarka2.visibility = View.VISIBLE
//                holder.bindingView.ivPhoto2.visibility = View.VISIBLE
//            Log.e("aaa", "onBindViewHolderClikc)")
//        }
        Log.e("aaa", "onBindViewHolder)")

    }

    fun update(newSweetList: MutableList<Sweets>) {

        sweetList.clear()
        sweetList.addAll(newSweetList)
        notifyDataSetChanged()

        Log.e("aaa", "update")
    }

    class Sweet2ViewHolder(val bindingView: ItemMyFragmentSweetBinding,
                           private  val clickListener: (Sweets) -> Unit) :
        RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Sweets) {
            bindingView.tvMarka2.text = item.marka
            bindingView.tvKod2.text = item.kod.toString()

            itemView.setOnClickListener { clickListener(item) }

            Glide
                .with(itemView.context)
                .load(chekPhoto(item))
                .into(bindingView.ivPhoto2)

            Log.e("aaa", "bind")
        }


        private fun chekPhoto(item: Sweets): String {

            when (item.marka) {
                SaveSweetsList.MARS ->
                    return "https://cdn1.ozone.ru/multimedia/1019690063.jpg"
                SaveSweetsList.SNICKERS ->
                    return "https://korzina.su/upload/iblock/315/315a795fada7a41e0094c1c1ee84d08f.jpg"
                SaveSweetsList.NUTS ->
                    return "https://edimdomakmv.ru/wp-content/uploads/2020/04/3051232h.jpg"
            }
            return ""
        }





    }

}

