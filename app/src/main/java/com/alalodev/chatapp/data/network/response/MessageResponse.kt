package com.alalodev.chatapp.data.network.response

import com.alalodev.chatapp.domain.model.MessageModel
import com.alalodev.chatapp.domain.model.UserModel

data class MessageResponse(
    val msg: String? = null,
    val hour: String? = null,
    val date: String? = null,
    val user: UserResponse? = null
) {
    fun toDomain(): MessageModel {
        return MessageModel(
            msg = msg.orEmpty(),
            hour = hour ?: "no date",
            date = date.orEmpty(),
            user = UserModel(useName = user?.useName ?: "Guess", admin = user?.admin ?: false)
        )
    }
}

data class UserResponse(val useName: String? = null, val admin: Boolean? = null)