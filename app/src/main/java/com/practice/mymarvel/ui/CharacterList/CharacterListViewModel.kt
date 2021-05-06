package com.practice.mymarvel.ui.characterlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.practice.mymarvel.data.repository.CharacterRepositoryImpl
import com.practice.mymarvel.internal.CharacterUIState
import com.practice.mymarvel.model.MarvelCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface MarvelCharacterListViewModel {
    val characterList: LiveData<CharacterUIState>
}

class CharacterListViewModelImpl(private val characterRepository: CharacterRepositoryImpl) :
    ViewModel(), MarvelCharacterListViewModel {

    private val _characterList =
        MutableStateFlow(CharacterUIState.Success(emptyList<MarvelCharacter>()))
    override val characterList: LiveData<CharacterUIState> = _characterList.asLiveData()

    init {
        viewModelScope.launch {
            characterRepository.fetchMarvelCharacters(DEFAULT_FETCH_LIMIT).collect {
                _characterList.value = CharacterUIState.Success(it)
            }
        }
    }

    companion object {
        val DEFAULT_FETCH_LIMIT = 99
    }
}

class CharacterListViewModelFactory(private val repository: CharacterRepositoryImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModelImpl::class.java)) {
            return CharacterListViewModelImpl(repository) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}
