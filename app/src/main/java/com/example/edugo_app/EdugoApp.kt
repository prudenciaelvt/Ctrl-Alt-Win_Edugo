package com.example.edugo_app

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.edugo_app.navigation.NavigationItem
import com.example.edugo_app.navigation.Screen
import com.example.edugo_app.pages.BerandaScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.data.desainGrafisCard
import com.example.edugo_app.data.matematikaCard
import com.example.edugo_app.pages.AkademikScreen
import com.example.edugo_app.pages.EditProfileScreen
import com.example.edugo_app.pages.ForumContent
import com.example.edugo_app.pages.KalenderScreen
import com.example.edugo_app.pages.KelasDesainScreen
import com.example.edugo_app.pages.MateriScreen
import com.example.edugo_app.pages.PapanPeringkatScreen
import com.example.edugo_app.pages.ProfileScreen
import com.example.edugo_app.pages.RegisterScreen
import com.example.edugo_app.pages.RiwayatTugasScreen
import com.example.edugo_app.pages.SemuaKelasScreen
import com.example.edugo_app.pages.SoalPage
import com.example.edugo_app.pages.SplashScreen
import com.example.edugo_app.pages.TugasAndaPage
import com.example.edugo_app.pages.TugasScreen
import com.example.edugo_app.pages.UjianPage
import com.example.edugo_app.pages.UjianSelesai
import com.example.edugo_app.pages.mathscreen
import com.example.edugo_app.utils.shouldShowBottomBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EdugoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Scaffold(
        topBar = {
            when (currentRoute) {
                Screen.Beranda.route -> BerandaTopBar(currentRoute, navController)
                Screen.Splash.route -> {}
                Screen.Daftar.route -> {}
                else -> {
                    AppTopBar(
                        title = when (currentRoute) {
                            Screen.Akademik.route -> "Materi dan Kelas"
                            Screen.Tugas.route -> "Tugas"
                            Screen.Forum.route -> "Forum"
                            Screen.Profile.route -> "Profile"
                            Screen.SemuaKelas.route -> "Semua Kelas"
                            Screen.Kalendar.route ->"Kalender Akademik"
                            Screen.Math.route -> "Matematika"
                            Screen.KelasDesain.route -> "Kelas"
                            Screen.PapanPeringkat.route -> "Papan Peringkat"
                            Screen.Materi.route -> "Materi"
                            Screen.Ujian.route -> "Ujian"
                            else -> ""
                        },
                        showBackButton = when (currentRoute) {
                            Screen.SemuaKelas.route -> true
                            Screen.Kalendar.route -> true
                            Screen.Math.route ->true
                            Screen.KelasDesain.route -> true
                            Screen.PapanPeringkat.route -> true
                            Screen.Materi.route -> true
                            Screen.Ujian.route -> true
                            Screen.Soal.route -> true
                            else -> false
                        },
                        onBackClick = { navController.popBackStack() }
                    )
                }
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                BottomNavBar(navController)
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(navController)
            }
            composable(Screen.Daftar.route) {
                RegisterScreen(navController)
            }
            composable("ujianselesai") {
                UjianSelesai(navController)
            }
            composable(Screen.Math.route) {
                val subjectCards = listOf(desainGrafisCard, matematikaCard)
                mathscreen(subjectCards, NavController)
            }
            composable(Screen.Beranda.route) {
                BerandaScreen(navController)
            }
            composable(Screen.Kalendar.route) {
                KalenderScreen()
            }
            composable(Screen.PapanPeringkat.route) {
                PapanPeringkatScreen(navController)
            }
            composable(Screen.Materi.route) {
                MateriScreen()
            }
            composable("tugasanda") {
                TugasAndaPage(navController = navController)
            }
            composable(Screen.Akademik.route) {
                val subjectCards = listOf(desainGrafisCard, matematikaCard)
                AkademikScreen(subjectCards = subjectCards, navController = navController)
            }
            composable(Screen.KelasDesain.route) {
                KelasDesainScreen()
            }
            composable(Screen.SemuaKelas.route) {
                SemuaKelasScreen(navController)
            }
            composable(Screen.Tugas.route) {
                TugasScreen(navController)
            }
            composable(Screen.Forum.route) {
                ForumContent()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(Screen.Ujian.route) {
                UjianPage(navController)
            }
            composable(Screen.Soal.route) {
                SoalPage(navController)
            }
            composable("editprofile") {
                EditProfileScreen(navController = navController)
            }
            composable("riwayattugas") {
                RiwayatTugasScreen(navController = navController)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerandaTopBar(currentRoute: String?, navController: NavHostController) {
    if (currentRoute == Screen.Beranda.route) {
        TopAppBar(
            title = {},
            navigationIcon = {
                Row (
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.imageprofile),
                        contentDescription = "image profile",
                        modifier = Modifier.size(49.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column (
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Halo",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Text (
                            text = "Ferdian",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {
                            navController.navigate(Screen.Kalendar.route)
                        },
                        modifier = Modifier.padding(end = 10.dp)
                    ) {
                        Icon (
                            painter = painterResource(id = R.drawable.iconcalender),
                            contentDescription = "kalender",
                            modifier = Modifier.size(29.dp),
                            tint = Color.White
                        )
                    }

                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color(0xFF006769),
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (showBackButton) {
                    IconButton(onClick = { onBackClick?.invoke() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
                Text(
                    text = title,
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                if (showBackButton) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.iconcalender),
                            contentDescription = "Calendar Icon",
                            tint = Color.Transparent,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF006769)
        )
    )
}


@Composable
private fun BottomNavBar(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Surface(
            modifier = Modifier
                .padding(horizontal = 13.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(90.dp),
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF95CFB9),
            shadowElevation = 8.dp
        ) {
            NavigationBar(
                containerColor = Color.Transparent,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry.value?.destination?.route

                val navigationItem = listOf(
                    NavigationItem(
                        title = "Beranda",
                        icon = R.drawable.iconberanda,
                        screen = Screen.Beranda
                    ),
                    NavigationItem(
                        title = "Akademik",
                        icon = R.drawable.iconakademik,
                        screen = Screen.Akademik
                    ),
                    NavigationItem(
                        title = "Tugas",
                        icon = R.drawable.icontugas,
                        screen = Screen.Tugas
                    ),
                    NavigationItem(
                        title = "Forum",
                        icon = R.drawable.iconforum,
                        screen = Screen.Forum
                    ),
                    NavigationItem(
                        title = "Profile",
                        icon = R.drawable.iconprofile,
                        screen = Screen.Profile
                    )
                )

                navigationItem.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.screen.route,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(23.dp)
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                color = Color.White,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    )
                }
            }
        }
    }
}


