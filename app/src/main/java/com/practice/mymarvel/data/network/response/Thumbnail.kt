package com.practice.mymarvel.data.network.response

import java.io.Serializable

data class Thumbnail(
    val extension: String,
    val path: String,
) : Serializable
