package com.example.nav_app.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.nav_app.R

// Define the data class for each grid item
data class SemuaKelasGrid(
    val label: String,
    @DrawableRes val imageRes: Int, // image resource ID
    val backgroundColor: Color // background color
)

// Define a function to return the list of grid items (you can also move this to a ViewModel if necessary)
fun getSemuaKelasGridItems(): List<SemuaKelasGrid> {
    return listOf(
        SemuaKelasGrid("1 DKV", R.drawable.image1, Color(0xFF006769)),
        SemuaKelasGrid("2 DKV", R.drawable.image2, Color(0xFF006769)),
        SemuaKelasGrid("3 DKV", R.drawable.image3, Color(0xFF006769)),
        SemuaKelasGrid("1 ATU", R.drawable.image4, Color(0xFF006769)),
        SemuaKelasGrid("2 ATU", R.drawable.image5, Color(0xFF006769)),
        SemuaKelasGrid("3 ATU", R.drawable.image6, Color(0xFF006769)),
        SemuaKelasGrid("1 ATPH", R.drawable.image7, Color(0xFF006769)),
        SemuaKelasGrid("2 ATPH", R.drawable.image8, Color(0xFF006769)),
        SemuaKelasGrid("3 ATPH", R.drawable.image9, Color(0xFF006769))
    )
}
