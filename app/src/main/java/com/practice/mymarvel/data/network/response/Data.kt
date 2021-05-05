package com.practice.mymarvel.data.network.response

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<CharacterResponse>,
    val total: Int
)
