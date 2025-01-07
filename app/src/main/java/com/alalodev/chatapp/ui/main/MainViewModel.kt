package com.alalodev.chatapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alalodev.chatapp.domain.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {
    fun saveNickName(nickName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserNameUseCase(nickName)
        }
    }
}