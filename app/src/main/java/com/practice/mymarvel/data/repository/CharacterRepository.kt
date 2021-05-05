package com.practice.mymarvel.data.repository

import com.practice.mymarvel.internal.Resource
import com.practice.mymarvel.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface CharacterRepository {
    suspend fun fetchMarvelCharacters(): Flow<Resource<List<MarvelCharacter>>>
}

class CharacterRepositoryImpl : CharacterRepository {
    override suspend fun fetchMarvelCharacters(): Flow<Resource<List<MarvelCharacter>>> {
        return flowOf(
            Resource.success(getList())
        )
    }

    fun getList(): List<MarvelCharacter> {
        return listOf(
            MarvelCharacter("test desc", 1, "test21", ""),
            MarvelCharacter("test desc", 1, "test22", ""),
            MarvelCharacter("test desc", 1, "test23", ""),
            MarvelCharacter("test desc", 1, "test24", ""),
            MarvelCharacter("test desc", 1, "test25", ""),
            MarvelCharacter("test desc", 1, "test26", ""),
            MarvelCharacter("test desc", 1, "test27", ""),
            MarvelCharacter("test desc", 1, "test28", ""),
            MarvelCharacter("test desc", 1, "test29", ""),
            MarvelCharacter("test desc", 1, "test30", ""),
            MarvelCharacter("test desc", 1, "test31", "")
        )
    }
}
