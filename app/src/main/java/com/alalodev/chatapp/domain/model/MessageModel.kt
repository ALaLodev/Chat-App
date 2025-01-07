package com.alalodev.chatapp.domain.model

data class MessageModel (
    val msg: String,
    val hour: String,
    val date: String,
    val user: UserModel
)
data class UserModel(val useName: String, val admin: Boolean)