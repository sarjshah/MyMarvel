package com.practice.mymarvel.internal

sealed class CharacterUIState<out R> {
    data class Success<out T>(val result: T) : CharacterUIState<T>()
    data class Error(val exception: Exception) : CharacterUIState<Nothing>()
    object Loading : CharacterUIState<Nothing>()
}
