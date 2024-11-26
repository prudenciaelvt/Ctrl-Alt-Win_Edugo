package com.example.edugo_app.navigation

sealed class Screen (val route: String) {
    object Beranda: Screen("beranda")
    object Akademik: Screen("akademik")
    object Tugas: Screen("tugas")
    object Forum: Screen("forum")
    object Profile: Screen("profile")
}