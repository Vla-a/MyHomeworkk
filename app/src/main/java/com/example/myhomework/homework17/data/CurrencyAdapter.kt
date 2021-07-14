package com.example.myhomework.homework17.data


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomework.databinding.ItemCurrencyBinding



class CurrencyAdapter (
    private val currencyList: MutableList<Currency> = mutableListOf()

    ) : RecyclerView.Adapter<CurrencyAdapter.CurrentyViewHolder>() {


    override fun getItemCount(): Int {
       return currencyList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentyViewHolder =
        CurrentyViewHolder(ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: CurrentyViewHolder, position: Int) {
       holder.bind(currencyList[position])
    }

    fun update(newCyrrencyList:MutableList<Currency>) {
        currencyList.clear()
        currencyList.addAll(newCyrrencyList)
        notifyDataSetChanged()
    }

        class CurrentyViewHolder(
            private val bindingView: ItemCurrencyBinding
        ) :   RecyclerView.ViewHolder(bindingView.root) {

            fun bind(item: Currency) {
                bindingView.tvId.text = item.id.toString()
                bindingView.tvName.text = item.name
                bindingView.ivSign.text = item.sign

            }
        }
}
