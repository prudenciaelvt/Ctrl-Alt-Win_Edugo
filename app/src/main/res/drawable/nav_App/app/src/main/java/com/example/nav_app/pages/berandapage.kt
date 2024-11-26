package com.example.nav_app.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nav_app.R
import com.example.nav_app.data.CardUser
import com.example.nav_app.data.Lesson
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke



@Composable
fun BerandaScreen(navController: NavHostController) {
    Surface() {
        Column {
            BerandaBar(navController)
            val user = CardUser(
                studentName = "John Doe",
                studentId = "123456",
                studentClass = "10A",
                lightningCount = 5,
                fireCount = 3
            )
            BerandaCardUser(cardUser = user)
            ProgresBelajarBox()
        }
    }
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BerandaBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val lessons = listOf(
        Lesson("Matematika", R.drawable.iconmatematika, "mathScreen"),
        Lesson("B. Inggris", R.drawable.iconbing, "englishScreen"),
        Lesson("B. Indonesia", R.drawable.iconindo, "indonesiaScreen"),
        Lesson("Komunikasi", R.drawable.icondesainkom, "communicationScreen"),
        Lesson("Fotografi", R.drawable.iconfoto, "photographyScreen"),
        Lesson("Tanaman", R.drawable.iconpembiakantanaman, "plantScreen"),
        Lesson("Peternakan", R.drawable.iconpemberianpakan, "feedingScreen"),
        Lesson("Manajemen Lahan", R.drawable.iconmanajemenlahan, "landManagementScreen")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(Color(0xFF006769))
    ) {
        Text(
            text = "Kamu lebih suka pelajaran apa?",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(lessons) { lesson ->
                LessonItem(
                    title = lesson.title,
                    icon = painterResource(id = lesson.icon),
                    onClick = {
                        navController.navigate(lesson.screenRoute)
                    }
                )
            }
        }
    }
}


@Composable
fun LessonItem(title: String, icon: Painter, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = icon,
            contentDescription = title,
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, shape = androidx.compose.foundation.shape.CircleShape)
                .padding(9.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                fontSize = 10.sp,
                color = Color.White
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerandaCardUser(cardUser: CardUser) {
    Card(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF006769)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Siswa/Siswi",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                TextButton(
                    onClick = { /* TODO: Add detail action */ }
                ) {
                    Text(
                        text = "Detail >",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.imageprofile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White) // Membuat lingkaran di belakang
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = cardUser.studentName,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Text(
                        text = "Id: ${cardUser.studentId}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )
                    Text(
                        text = "Kelas: ${cardUser.studentClass}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Baris bawah: Lightning dan Fire
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Lightning
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.iconthunder),
                        contentDescription = "Lightning",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "300",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF006769)
                        )
                    )
                }

                // Fire
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.iconfire),
                        contentDescription = "Fire",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "30",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF006769)
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun ProgresBelajarBox() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Progres Belajar",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    LegendItem(color = Color(0xFF8FD3C1), label = "Minggu ini")
                    LegendItem(color = Color(0xFF567D6C), label = "Minggu Kemarin")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Progress bars
            ProgressBarRow(label = "penyelesaian kelas", progressThisWeek = 0.7f, progressLastWeek = 0.5f)
            Spacer(modifier = Modifier.height(8.dp))
            ProgressBarRow(label = "penyelesaian Tugas", progressThisWeek = 0.9f, progressLastWeek = 0.4f)

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "1 November - 28 November 2024",
                style = TextStyle(fontSize = 12.sp, color = Color.Gray)
            )
        }
    }
}

@Composable
fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        Canvas(
            modifier = Modifier.size(12.dp)
        ) {
            drawCircle(color = color)
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = label, style = TextStyle(fontSize = 12.sp))
    }
}

@Composable
fun ProgressBarRow(label: String, progressThisWeek: Float, progressLastWeek: Float) {
    Column {
        Text(
            text = label,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .padding(vertical = 4.dp)
        ) {
            Canvas(
                modifier = Modifier.matchParentSize()
            ) {
                // Background bar
                drawRoundRect(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    size = Size(size.width, 20.dp.toPx()),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(10.dp.toPx())
                )
                // Last week's progress
                drawRoundRect(
                    color = Color(0xFF567D6C),
                    size = Size(size.width * progressLastWeek, 20.dp.toPx()),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(10.dp.toPx())
                )
                // This week's progress
                drawRoundRect(
                    color = Color(0xFF8FD3C1),
                    size = Size(size.width * progressThisWeek, 20.dp.toPx()),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(10.dp.toPx()),
                    style = Stroke(width = 3.dp.toPx())
                )
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun NavappPreview() {
//    BerandaScreen(navController = rememberNavController())
//}

