package com.practice.bbapplication.model

import java.io.Serializable

data class Thumbnail(
    val extension: String,
    val path: String,
) : Serializable
