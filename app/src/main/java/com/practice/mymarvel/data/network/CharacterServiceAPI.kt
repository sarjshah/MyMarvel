package com.practice.mymarvel.data.network

import com.practice.mymarvel.data.network.response.MarvelCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterServiceAPI {
    @GET(
        "characters?ts=1&" +
            "apikey=678c0bb6d6aea2fbde954e9c8e170586&" +
            "hash=6c5502e0089e46828d91a0d16149b185"
    )
    suspend fun getMarvelCharacters(
        @Query("limit") limit: Int
    ): MarvelCharacterResponse

    @GET(
        "characters/{characterId}?ts=2&" +
            "apikey=678c0bb6d6aea2fbde954e9c8e170586&" +
            "hash=fdf9e251bd923dcc7599fb1f514e392e"
    )
    suspend fun getCharacter(
        @Path("characterId") id: Int
    ): MarvelCharacterResponse
}
