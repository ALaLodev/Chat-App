package com.alalodev.chatapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.alalodev.chatapp.databinding.ItemChatMeBinding
import com.alalodev.chatapp.databinding.ItemChatOtherBinding
import com.alalodev.chatapp.domain.model.MessageModel

class ChatViewHolder(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(messageModel: MessageModel, itemViewType: Int) {
        when(itemViewType){
            ChatAdapter.SENT_MESSAGE -> bindSentMessage(messageModel)
            ChatAdapter.RECEIVED_MESSAGE -> bindReceivedMessage(messageModel)

        }
    }

    private fun bindReceivedMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemChatOtherBinding
        binding.tvDateOther.text = messageModel.date
        binding.tvChatOther.text = messageModel.msg
        binding.tvNameOther.text = messageModel.user.useName
        binding.tvDateOther.text = messageModel.hour
    }

    private fun bindSentMessage(messageModel: MessageModel) {
        val currentBinding = binding as ItemChatMeBinding
        binding.tvChatMe.text = messageModel.msg
        binding.tvDateMe.text = messageModel.date
        binding.tvHour.text = messageModel.hour
    }
}