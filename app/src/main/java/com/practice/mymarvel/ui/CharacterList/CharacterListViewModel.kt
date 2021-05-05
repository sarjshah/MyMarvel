package com.practice.mymarvel.ui.CharacterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.practice.bbapplication.model.CharacterResponse
import com.practice.mymarvel.data.repository.CharacterRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

interface CharacterListViewModel {
    val characterList: LiveData<List<CharacterResponse>>
}

class CharacterListViewModelImpl(private val characterRepository: CharacterRepositoryImpl) :
    ViewModel(), CharacterListViewModel {

    private val _characterList = MutableStateFlow<List<CharacterResponse>>(emptyList())
    override val characterList: LiveData<List<CharacterResponse>> = _characterList.asLiveData()

    init {
        viewModelScope.launch {
            characterRepository.fetchCharacters().collect {
                _characterList.value = it
            }
        }
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
