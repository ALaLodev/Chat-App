package com.alalodev.chatapp.data.network

import com.alalodev.chatapp.data.network.dto.MessageDto
import com.alalodev.chatapp.data.network.response.MessageResponse
import com.alalodev.chatapp.domain.model.MessageModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.getValue
import com.google.firebase.database.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {

    companion object { private const val PATH = "message" }

    fun sendMsgToFirebase(messageDto: MessageDto){
        val newMsg = reference.child(PATH).push()
        newMsg.setValue(messageDto)
    }

    fun getMessage(): Flow<List<MessageModel>>{
        return reference.child(PATH).snapshots.map { dataSnapshot ->
            dataSnapshot.children.mapNotNull { it.getValue(MessageResponse::class.java)?.toDomain() }
        }
    }
}