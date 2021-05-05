package com.practice.bbapplication.model

import java.io.Serializable

data class CharacterResponse(
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail,
    val resourceURI: String
) : Serializable
