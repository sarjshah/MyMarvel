package com.practice.mymarvel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelCharacter(
    val description: String,
    val id: Int,
    val name: String,
    val imageUrl: String
) : Parcelable {
    companion object {
        fun empty() =
            MarvelCharacter("", 0, "", "")
    }
}
