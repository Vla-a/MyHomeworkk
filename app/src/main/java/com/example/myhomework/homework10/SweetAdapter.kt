package com.example.myhomework.homework10


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myhomework.databinding.ItemSweetBinding

class SweetAdapter(
    private val sweetList: MutableList<Sweets>
) : RecyclerView.Adapter<SweetAdapter.SweetViewHolder>() {

    override fun getItemCount(): Int = sweetList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder =
        SweetViewHolder(
            ItemSweetBinding.inflate(LayoutInflater.from(parent.context))
        )


    override fun onBindViewHolder(holder: SweetViewHolder, position: Int) {
        holder.bind(sweetList[position])
    }

    fun update(newSweetList: MutableList<Sweets>) {

        sweetList.clear()
        sweetList.addAll(newSweetList)
        notifyDataSetChanged()
    }

    class SweetViewHolder(val bindingView: ItemSweetBinding) :
        RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Sweets) {
            bindingView.tvMarka.text = item.marka
            bindingView.tvKod.text = item.kod.toString()

            Glide
                .with(itemView.context)
                .load(chekPhoto(item))
                .into(bindingView.ivPhoto)
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