package com.example.edugo_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.R
import com.example.edugo_app.data.CardUser
import com.example.edugo_app.data.Lesson
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.edugo_app.navigation.Screen

@Composable
fun BerandaScreen(navController: NavHostController) {
    Surface() {
        Column {
            BerandaBar(navController)
            val user = CardUser(
                studentName = "Ferdian",
                studentId = "2111340",
                studentClass = "10A",
                lightningCount = 5,
                fireCount = 3
            )
            BerandaCardUser(cardUser = user)
            ProgressBelajarBox()
        }
    }
}

@Composable
fun BerandaBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val Lessons = listOf(
        Lesson("Matematika", R.drawable.iconmatematika, "mathscreen"),
        Lesson("B. Inggris", R.drawable.iconbing, "bingscreen"),
        Lesson("B. Indonesia", R.drawable.iconindo, "indoscreen"),
        Lesson("Desain Komunikasi", R.drawable.icondesainkom, "desainkomscreen"),
        Lesson("Fotografi", R.drawable.iconfoto, "fotoscreen"),
        Lesson("Pembiakan Tanaman", R.drawable.iconpembiakantanaman, "plantscreen"),
        Lesson("Pemberian Pakan", R.drawable.iconpemberianpakan, "feedingscreen"),
        Lesson("Manajemen Lahan", R.drawable.iconmanajemenlahan, "manajemenlahanscreen"),
    )
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(Color(0xFF006769))
    ){
        Text(
            text = "Kamu lebih suka pelajaran apa?",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal =16.dp, vertical = 8.dp )
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            items(Lessons) { lesson ->
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
    Column (

    ) {
        Image(
            painter = icon,
            contentDescription = title,
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, shape = CircleShape)
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

@Composable
fun BerandaCardUser(cardUser: CardUser){
    Card (
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
    ){
        Column (
            modifier = Modifier
                .padding(16.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Siswa/Siswi",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
                TextButton(
                    onClick = { }
                ) {
                    Text(
                        text = "Detail >",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }

            }
            Spacer(modifier = Modifier.height(12.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    painter= painterResource(id = R.drawable.imageprofile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White)
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
                        text =  "Kelas: ${cardUser.studentClass}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White

                        )
                    )

                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.iconthunder),
                    contentDescription = "lightning",
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

            Row (
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

@Composable
fun ProgressBelajarBox() {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
               Text (
                   "Progress Belajar",
                   style = TextStyle(
                       fontSize = 18.sp,
                       fontWeight = FontWeight.Bold

                   )
               )
                Column (
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TempoItem(color = Color(0xFF8FD3C1), label = "Minggu ini")
                    TempoItem(color = Color(0xFF567D6C), label = "Minggu Kemarin")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            ProgressBarRow (
                label = "Penyelesaian Kelas", progressThisWeek = 0.7f, progressLastWeek = 0.5f
            )
            Spacer(modifier = Modifier.height(8.dp))
            ProgressBarRow (
                label = "Penyelesaian Tugas", progressThisWeek = 0.9f, progressLastWeek = 0.4f
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "1 November - 28 November 2024",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )
        }
    }
}

@Composable
fun TempoItem(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier.size(12.dp)
        ) {
            drawCircle (color = color)
        }
        Spacer(modifier = Modifier.width(4.dp))
    }
}

@Composable
fun ProgressBarRow(label: String, progressThisWeek: Float, progressLastWeek: Float) {
    Column {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .padding(bottom = 4.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Canvas(
                modifier = Modifier.matchParentSize()
            ) {
                drawRoundRect(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    size = Size(size.width, 20.dp.toPx()),
                    cornerRadius = CornerRadius(10.dp.toPx())
                )
                drawRoundRect(
                    color = Color(0xFF567D6C),
                    size = Size(size.width * progressLastWeek, 20.dp.toPx()),
                    cornerRadius = CornerRadius(10.dp.toPx())
                )
                drawRoundRect(
                    color = Color(0xFF8FD3C1),
                    size = Size(size.width * progressThisWeek, 20.dp.toPx()),
                    cornerRadius = CornerRadius(10.dp.toPx()),
                    style = Stroke(width = 3.dp.toPx())
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EdugoAppPreview() {
    BerandaScreen(navController = rememberNavController())
}

