package com.example.myhomework.homework15.database


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Query("SELECT * FROM massage_table")
    fun getMessageList(): Flow<List<MessageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMessage(message: MessageEntity)

    @Delete
    suspend fun deleteMessage(message: MessageEntity)
}