package com.example.edugo_app.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.edugo_app.R

data class SemuaKelasGrid(
    val label: String,
    @DrawableRes val imageRes: Int,
    val backgroundColor: Color
)

fun getSemuaKelasGridItems(): List<SemuaKelasGrid> {
    return listOf(
        SemuaKelasGrid("1 DKV", R.drawable.image1, Color(0xFF006769)),
        SemuaKelasGrid("2 DKV", R.drawable.image2, Color(0xFF006769)),
        SemuaKelasGrid("3 DKV", R.drawable.image3, Color(0xFF006769)),
        SemuaKelasGrid("1 DKV", R.drawable.image4, Color(0xFF006769)),
        SemuaKelasGrid("2 DKV", R.drawable.image5, Color(0xFF006769)),
        SemuaKelasGrid("3 DKV", R.drawable.image6, Color(0xFF006769)),
        SemuaKelasGrid("1 DKV", R.drawable.image7, Color(0xFF006769)),
        SemuaKelasGrid("2 DKV", R.drawable.image8, Color(0xFF006769)),
        SemuaKelasGrid("3 DKV", R.drawable.image9, Color(0xFF006769))
    )
}