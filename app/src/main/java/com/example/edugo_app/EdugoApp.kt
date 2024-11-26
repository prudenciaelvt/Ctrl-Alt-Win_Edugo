package com.example.edugo_app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.edugo_app.navigation.NavigationItem
import com.example.edugo_app.navigation.Screen
import com.example.edugo_app.pages.BerandaScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.pages.AkademikScreen
import com.example.edugo_app.pages.ForumScreen
import com.example.edugo_app.pages.ProfileScreen
import com.example.edugo_app.pages.TugasScreen
import com.example.edugo_app.utils.shouldShowBottomBar

@Composable
fun EdugoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Scaffold (
        topBar = {
            BerandaTopBar()
        },
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                BottomNavBar(navController)
            }
        }
    ){contentPadding ->
        NavHost (
            navController = navController,
            startDestination = Screen.Beranda.route,
            modifier = modifier.padding(contentPadding)
        ) {
           composable(Screen.Beranda.route) {
               BerandaScreen()
           }
            composable(Screen.Akademik.route) {
                AkademikScreen()
            }
            composable(Screen.Beranda.route) {
                TugasScreen()
            }
            composable(Screen.Beranda.route) {
                ForumScreen()
            }
            composable(Screen.Beranda.route) {
                ProfileScreen()
            }
        }


    }

}


@Composable
fun BerandaTopBar() {
    Text(text = "Test beranda")
}


@Composable
private fun BottomNavBar(
    navController: NavHostController
) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 13.dp, vertical = 8.dp)
            .fillMaxWidth()
            .shadow(elevation = 8.dp)
            .height(90.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF95CFB9)
    ) {
        NavigationBar (
            containerColor = Color.Transparent,
            modifier = Modifier.padding(horizontal = 8.dp)
        ){
            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry.value?.destination?.route

            val navigationItem = listOf(
                NavigationItem (
                    title = "Beranda",
                    icon = R.drawable.iconberanda,
                    screen = Screen.Beranda
                ),
                NavigationItem (
                    title = "Akademik",
                    icon = R.drawable.iconakademik,
                    screen = Screen.Akademik
                ),
                NavigationItem (
                    title = "Tugas",
                    icon = R.drawable.icontugas,
                    screen = Screen.Tugas
                ),
                NavigationItem (
                    title = "Forum",
                    icon = R.drawable.iconforum,
                    screen = Screen.Forum
                ),
                NavigationItem (
                    title = "Profile",
                    icon = R.drawable.iconprofile,
                    screen = Screen.Profile
                )

            )

            navigationItem.forEach{item ->
                NavigationBarItem(
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState =true
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


@Preview(showBackground = true)
@Composable
fun EdugoAppPreview() {
    EdugoApp()
}
