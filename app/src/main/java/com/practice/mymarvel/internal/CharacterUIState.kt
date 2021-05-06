package com.practice.mymarvel.internal

sealed class CharacterUIState {
    data class Success<out T>(val result: T) : CharacterUIState()
    data class Error(val exception: Throwable) : CharacterUIState()
}
