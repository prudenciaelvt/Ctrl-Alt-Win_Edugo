package com.example.edugo_app.pages

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.edugo_app.R
import com.example.edugo_app.AppTopBar


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SoalPage(navController: NavHostController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Soal",
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.55f)
                        .background(
                            color = Color(0xFF006769),
                            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                        )
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "01-10",
                                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = "09:00",
                                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFFFFF))
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        LinearProgressIndicator(
                            progress = 0.6f,
                            color = Color(0xFF95CFB9),
                            trackColor = Color(0xFFE0E0E0),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(90.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(8.dp),
                                clip = false
                            )
                            .background(Color.White, shape = RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "1. Jika sebuah segitiga memiliki panjang alas 8 cm dan tinggi 6 cm, maka luas segitiga tersebut adalah...",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        listOf("A) 12 cm²", "B) 24 cm²", "C) 48 cm²", "D) 36 cm²").forEachIndexed { index, option ->
                            OutlinedButton(
                                onClick = { /* Handle answer selection */ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
                            ) {
                                Text(
                                    text = option,
                                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { navController.popBackStack() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF80B3B4)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .shadow(
                                    elevation = 0.5.dp,
                                    shape = RoundedCornerShape(8.dp),
                                    clip = false
                                )
                        ) {
                            Text("Kembali", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { navController.navigate("ujianselesai") },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006769)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .shadow(
                                    elevation = 0.5.dp,
                                    shape = RoundedCornerShape(8.dp),
                                    clip = false,
                                )
                        ) {
                            Text("Lanjut", color = Color.White)
                        }
                    }

                }
            }
        }
    )
}