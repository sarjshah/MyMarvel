package com.practice.mymarvel.ui.CharacterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.practice.bbapplication.model.CharacterResponse
import com.practice.bbapplication.model.Thumbnail
import kotlinx.coroutines.flow.MutableStateFlow

interface CharacterListViewModel {
    val characterList: LiveData<List<CharacterResponse>>
}

class CharacterListViewModelImpl : ViewModel(), CharacterListViewModel {

    private val _characterList = MutableStateFlow<List<CharacterResponse>>(emptyList())
    override val characterList: LiveData<List<CharacterResponse>> = _characterList.asLiveData()

    init {
        _characterList.value = listOf(
            CharacterResponse("test desc", 1, "test1", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test2", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test3", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test4", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test5", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test6", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test7", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test8", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test9", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test10", Thumbnail("testext", "testpath"), ""),
            CharacterResponse("test desc", 1, "test11", Thumbnail("testext", "testpath"), "")
        )
    }
}