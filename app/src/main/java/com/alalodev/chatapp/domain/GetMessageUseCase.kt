package com.alalodev.chatapp.domain

import com.alalodev.chatapp.data.network.FirebaseChatService
import javax.inject.Inject

class GetMessageUseCase @Inject constructor(private val firebaseChatService: FirebaseChatService) {
    operator fun invoke() = firebaseChatService.getMessage()
}