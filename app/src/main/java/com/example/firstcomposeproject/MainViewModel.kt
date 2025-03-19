package com.example.firstcomposeproject

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow<Boolean>(true)
    val state = _state

    fun changeState() {
        _state.value = !_state.value
    }

}