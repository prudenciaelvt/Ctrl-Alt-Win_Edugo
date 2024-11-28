package com.example.edugo_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.edugo_app.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TugasScreen(navController: NavHostController) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF))
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Kategori", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(listOf("1 DKV", "2 ATU", "3 ATPH", "Desain Graphic", "Agama", "Matematika")) { category ->
                    val backgroundColor = if (category == "1 DKV") {
                        Color(0xFF006769)
                    } else {
                        Color(0xFF80B3B4)
                    }
                    CategoryChip(category, backgroundColor = backgroundColor)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item { TaskSection("Tugas Anda", "Tugas Anda", navController) }
                item { TaskSection("Ujian", "ujian", navController) }
                item { TaskSection("Quiz", "quiz", navController) }
            }
        }
    }
}


@Composable
fun CategoryChip(category: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = category,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TaskSection(title: String, type: String, navController: NavHostController) {
    Column {
        Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(3) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .clickable {
                            when (type) {
                                "Tugas Anda" -> navController.navigate("tugasanda")
                                "ujian" -> navController.navigate("ujian")
                                "quiz" -> navController.navigate("quiz")
                                else -> {}
                            }
                        }
                ) {
                    TaskCard()
                }
            }
        }
    }
}

@Composable
fun TaskCard() {
    Column(
        modifier = Modifier
            .width(200.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagedesaingrafis),
            contentDescription = "Gambar Matematika",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Matematika", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Pengumpulan: 22 Nov 2024", fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(1.dp))
        Text("Jam: 17:00 WIB", fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(1.dp))
        Text("Status: Belum Dikumpulkan", fontSize = 12.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp).padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFFBF8EF), shape = RoundedCornerShape(8.dp))
                    .shadow(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(2.dp),
                        clip = true,
                    )
                    .padding(horizontal = 9.dp, vertical = 6.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_bolt),
                        contentDescription = "Petir",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("50", fontSize = 14.sp, color = Color.Black)
                }
            }
        }
    }
}
