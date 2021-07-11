package com.example.myhomework.homework15


import androidx.lifecycle.*
import com.example.myhomework.homework15.database.MessageEntity
import com.example.myhomework.homework15.database.MessageRepositiry
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class HomeWork15ViewModel(
    private val messageRepository: MessageRepositiry
) : ViewModel() {

    val messageListLiveData: LiveData<List<Message>> =
        messageRepository.getMessagesList().asLiveData()

    fun addMessageToDatabase(message: String) {

        val newMessage = MessageEntity(
            message,
            SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ROOT).format(System.currentTimeMillis())
        )

        viewModelScope.launch {
            messageRepository.addMessages(newMessage)
        }
    }

    fun deleteMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.deleteMessage(message)
        }
    }
}

class HomeWork15ViewModelFactory(
    private val messageRepository: MessageRepositiry
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeWork15ViewModel(messageRepository) as T
    }
}