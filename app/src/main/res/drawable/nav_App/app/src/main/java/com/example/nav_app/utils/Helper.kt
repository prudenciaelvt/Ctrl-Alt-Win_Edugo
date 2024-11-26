package com.example.nav_app.utils

import com.example.nav_app.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Beranda.route,
        Screen.Akademik.route,
        Screen.Tugas.route,
        Screen.Forum.route,
        Screen.Profile.route
    )
}
