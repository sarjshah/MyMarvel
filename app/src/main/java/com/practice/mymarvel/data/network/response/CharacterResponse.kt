package com.practice.mymarvel.data.network.response

import com.practice.mymarvel.internal.NetworkMapper
import com.practice.mymarvel.model.MarvelCharacter

data class CharacterResponse(
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail,
    val resourceURI: String
)

class CharacterResponseMapper() : NetworkMapper<CharacterResponse, MarvelCharacter> {
    override fun toDomain(networkResponse: CharacterResponse): MarvelCharacter {
        return MarvelCharacter(
            networkResponse.description,
            networkResponse.id,
            networkResponse.name,
            imageUrl =
            "${networkResponse.thumbnail.path}/portrait_small" +
                ".${networkResponse.thumbnail.extension}"
        )
    }

    override fun toDomainList(networkResponseList: List<CharacterResponse>): List<MarvelCharacter> {
        return networkResponseList.map {
            toDomain(it)
        }
    }
}
