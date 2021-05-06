package com.practice.mymarvel.data.repository

import com.practice.mymarvel.data.network.CharacterServiceAPI
import com.practice.mymarvel.data.network.response.CharacterResponseMapper
import com.practice.mymarvel.model.MarvelCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

interface CharacterRepository {
    suspend fun fetchMarvelCharacters(limit: Int): Flow<List<MarvelCharacter>>
    suspend fun fetchMarvelCharacter(id: Int): Flow<MarvelCharacter>
}

class CharacterRepositoryImpl(private val service: CharacterServiceAPI) : CharacterRepository {
    override suspend fun fetchMarvelCharacters(limit: Int): Flow<List<MarvelCharacter>> =
        withContext(Dispatchers.IO) {
            flowOf(
                CharacterResponseMapper()
                    .toDomainList(
                        service.getMarvelCharacters(limit)
                            .data.results
                    )
            )
        }

    override suspend fun fetchMarvelCharacter(id: Int): Flow<MarvelCharacter> =
        withContext(Dispatchers.IO) {
            flowOf(
                CharacterResponseMapper().toDomain(
                    service.getCharacter(id).data.results.first()
                )
            )
        }
}
