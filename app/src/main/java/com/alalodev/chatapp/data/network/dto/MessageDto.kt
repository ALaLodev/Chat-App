package com.alalodev.chatapp.data.network.dto

data class MessageDto (
    val msg: String,
    val hour: String,
    val date: String,
    val user: UserDto
)
data class UserDto(val useName: String, val admin: Boolean)