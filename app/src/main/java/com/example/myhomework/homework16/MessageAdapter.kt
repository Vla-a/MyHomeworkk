package com.example.myhomework.homework16

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomework.databinding.ItemMessageBinding


class MessageAdapter(
    private val messageList: MutableList<Message>,
    private val clickListener: (Message) -> Unit
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun getItemCount(): Int = messageList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder =
        MessageViewHolder(
            ItemMessageBinding.inflate(LayoutInflater.from(parent.context)), clickListener
        )


    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messageList[position])
    }

    fun update(newMessageList: MutableList<Message>) {
        messageList.clear()
        messageList.addAll(newMessageList)
        notifyDataSetChanged()
    }

    class MessageViewHolder(
        private val bindingView: ItemMessageBinding,
        private val clickListener: (Message) -> Unit
    ) :
        RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Message) {
            bindingView.tvText.text = item.message
            bindingView.tvDate.text = item.date

            itemView.setOnLongClickListener {
                clickListener(item)
                true
            }
        }
    }

}