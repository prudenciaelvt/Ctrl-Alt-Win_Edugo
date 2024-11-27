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
import com.example.edugo_app.AppTopBar
import com.example.edugo_app.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UjianPage(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Ujian",
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )
        },
        content = {
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
                        .padding(bottom = 64.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = painterResource(id = R.drawable.img_ujian),
                        contentDescription = "Gambar Ujian",
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .size(350.dp)
                            .padding(16.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Box(
                        modifier = Modifier
                            .offset(y = (-24).dp)
                            .padding(horizontal = 16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            InfoButton(
                                text = "10 Pertanyaan",
                                backgroundColor = Color(0xFFEAF6F6),
                                modifier = Modifier
                                    .weight(1f)
                                    .shadow(
                                        elevation = 8.dp,
                                        shape = RoundedCornerShape(8.dp),
                                        clip = false
                                    )
                            )
                            InfoButton(
                                text = "+50 Point",
                                backgroundColor = Color(0xFFEAF6F6),
                                modifier = Modifier
                                    .weight(1f)
                                    .shadow(
                                        elevation = 8.dp,
                                        shape = RoundedCornerShape(8.dp),
                                        clip = false
                                    )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .background(Color.White, shape = RoundedCornerShape(16.dp))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Deskripsi",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Ujian ini bertujuan untuk mengukur pemahaman siswa terhadap konsep-konsepdasar matematika serta kemampuan dalam menerapkannya pada berbagai masalah.",
                            style = TextStyle(fontSize = 14.sp),
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user_edugo2),
                            contentDescription = "Foto Guru",
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Bu Aryani",
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = "Guru Matematika",
                                style = TextStyle(fontSize = 14.sp),
                                color = Color.Gray
                            )
                        }
                    }
                }

                Button(
                    onClick = { navController.navigate("soal") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006769)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .height(48.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(8.dp),
                            clip = false
                        )
                ) {
                    Text(
                        text = "Mulai",
                        style = TextStyle(color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    )
                }

            }
        }
    )
}


@Composable
fun InfoButton(text: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        )
    }
}

