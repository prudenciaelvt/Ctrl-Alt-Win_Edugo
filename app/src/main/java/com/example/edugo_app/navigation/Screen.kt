package com.example.edugo_app.navigation

sealed class Screen (val route: String) {
    object Login: Screen("login")
    object Daftar: Screen("register")
    object Beranda: Screen("beranda")
    object Akademik: Screen("akademik")
    object Tugas: Screen("tugas")
    object Forum: Screen("forum")
    object Profile: Screen("profile")
    object SemuaKelas: Screen("semuakelas")
    object Splash: Screen("splashscreen")
    object Math: Screen("mathscreen")
    object Ujian: Screen("ujian")
    object Soal: Screen("soal")
    object Kalendar: Screen("kalendar")
    object KelasDesain: Screen("kelasdesain")
    object PapanPeringkat: Screen("papanperingkat")
    object Materi: Screen("materi")
}