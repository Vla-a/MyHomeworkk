package com.example.myhomework.homework16.database

import com.example.myhomework.homework16.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageRepository(
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

    private fun Message.entity() = MessageEntity(this.message, this.date)
}