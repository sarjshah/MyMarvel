package com.practice.mymarvel.data.repository

import com.practice.mymarvel.data.network.CharacterServiceAPI
import com.practice.mymarvel.data.network.response.CharacterResponseMapper
import com.practice.mymarvel.internal.Resource
import com.practice.mymarvel.model.MarvelCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

interface CharacterRepository {
    suspend fun fetchMarvelCharacters(limit: Int): Flow<Resource<List<MarvelCharacter>>>
}

class CharacterRepositoryImpl(private val service: CharacterServiceAPI) : CharacterRepository {
    override suspend fun fetchMarvelCharacters(limit: Int): Flow<Resource<List<MarvelCharacter>>> {
        var result: Resource<List<MarvelCharacter>>
        withContext(Dispatchers.IO) {
            result = Resource.success(
                CharacterResponseMapper()
                    .toDomainList(service.getMarvelCharacters(limit).data.results)
            )
        }
        return flowOf(result)
    }
}
