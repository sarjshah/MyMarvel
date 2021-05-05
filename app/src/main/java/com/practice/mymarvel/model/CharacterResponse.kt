package com.practice.bbapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterResponse(
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail,
    val resourceURI: String
) : Parcelable {
    val imageUrl = "${thumbnail.path}/portrait_small.${thumbnail.extension}"
}
