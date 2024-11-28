package com.example.edugo_app.utils

import com.example.edugo_app.navigation.Screen

fun String?.shouldShowBottomBar() : Boolean {
    return this in setOf(
        Screen.Beranda.route,
        Screen.Akademik.route,
        Screen.Tugas.route,
        Screen.Forum.route,
        Screen.Profile.route
    )
}
