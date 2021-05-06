package com.practice.mymarvel.ui.CharacterDetails

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.practice.mymarvel.internal.CharacterUIState
import com.practice.mymarvel.model.MarvelCharacter
import kotlinx.coroutines.flow.MutableStateFlow

interface CharacterDetailsViewModel {
    val characterDetails: LiveData<CharacterUIState>
}

class CharacterDetailsViewModelImpl() : Fragment(), CharacterDetailsViewModel {
    private val _characterDetails =
        MutableStateFlow(CharacterUIState.Success(MarvelCharacter.empty()))
    override val characterDetails:
        LiveData<CharacterUIState> = _characterDetails.asLiveData()

    init {
    }
}
