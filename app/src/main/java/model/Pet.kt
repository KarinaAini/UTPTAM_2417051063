package model

import androidx.annotation.DrawableRes

data class Pet(
    val nama: String,
    val deskripsi: String,
    @DrawableRes val imageRes: Int
)

