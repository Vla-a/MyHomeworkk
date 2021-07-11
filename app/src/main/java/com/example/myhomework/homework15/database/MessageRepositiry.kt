package com.example.myhomework.homework15.database

import com.example.myhomework.homework15.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageRepositiry(
    private val messageDao: MessageDao
) {

    fun getMessagesList(): Flow<List<Message>> =
        messageDao.getMessageList().map { messageEntities ->
            messageEntities.map { messageEntities ->
                Message(messageEntities.message, messageEntities.date)
            }
        }

    suspend fun addMessages(message: MessageEntity) {
        messageDao.addMessage(message)

    }

    suspend fun deleteMessage(message: Message) {

        messageDao.deleteMessage(message.entity())
    }

    fun Message.entity() = MessageEntity(this.message, this.date)
}