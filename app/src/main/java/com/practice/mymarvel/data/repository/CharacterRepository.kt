package com.practice.mymarvel.data.repository

import com.practice.bbapplication.model.CharacterResponse
import com.practice.bbapplication.model.Thumbnail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface CharacterRepository {
    suspend fun fetchCharacters(): Flow<List<CharacterResponse>>
}

class CharacterRepositoryImpl : CharacterRepository {
    override suspend fun fetchCharacters(): Flow<List<CharacterResponse>> {
        return flowOf(
            listOf(
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
        )
    }
}
