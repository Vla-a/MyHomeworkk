package com.example.myhomework.homework16


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myhomework.homework16.database.MessageEntity
import com.example.myhomework.homework16.database.MessageRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class HomeWork15ViewModel(
   private val messageRepository: MessageRepository
) : ViewModel() {

//    private val messageRepository: MessageRepository by inject()
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

//class HomeWork15ViewModelFactory(
//    private val messageRepository: MessageRepository
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return HomeWork15ViewModel(messageRepository) as T
//    }
//}