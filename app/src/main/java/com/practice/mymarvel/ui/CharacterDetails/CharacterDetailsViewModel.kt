package com.practice.mymarvel.ui.CharacterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.practice.mymarvel.data.repository.CharacterRepositoryImpl
import com.practice.mymarvel.internal.CharacterUIState
import com.practice.mymarvel.model.MarvelCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface CharacterDetailsViewModel {
    val characterDetails: LiveData<CharacterUIState.Success<MarvelCharacter>>
}

class CharacterDetailsViewModelImpl(private val repository: CharacterRepositoryImpl) :
    ViewModel(), CharacterDetailsViewModel {
    private val _characterDetails =
        MutableStateFlow(CharacterUIState.Success(MarvelCharacter.empty()))
    override val characterDetails:
        LiveData<CharacterUIState.Success<MarvelCharacter>> = _characterDetails.asLiveData()

    fun fetchCharacter(characterId: Int) {
        viewModelScope.launch {
            repository.fetchMarvelCharacter(characterId).collect {
                _characterDetails.value = CharacterUIState.Success(it)
            }
        }
    }
}
