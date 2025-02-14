package com.example.edugo_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.edugo_app.R
import com.example.edugo_app.data.CardUser
import com.example.edugo_app.data.Lesson
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.navigation.Screen

@Composable
fun BerandaScreen(navController: NavHostController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    Surface {
        Column (
            modifier = Modifier.background(Color.White)
        ){
            BerandaBar(navController)
            LazyColumn(
//            modifier = Modifier.fillMaxSize()
            ) {
                item {
                    val user = CardUser(
                        studentName = "Ferdian",
                        studentId = "2111340",
                        studentClass = "10A",
                        lightningCount = 5,
                        fireCount = 3
                    )
                    BerandaCardUser(cardUser = user, navController)
                }
                item {
                    ProgressBelajarBox()
                }
                item {
                    ImageBanner()
                }
            }
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
            .height(280.dp)
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
fun BerandaCardUser(cardUser: CardUser, navController: NavHostController){
    Card (
        modifier = Modifier
            .padding(14.dp)
            .background(Color.White)
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
                    onClick = { navController.navigate(Screen.PapanPeringkat.route) }
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
               horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
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
}

@Composable
fun ProgressBelajarBox() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
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
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    LegendItem(color = Color(0xFF95CFB9), label = "Minggu ini")
                    LegendItem(color = Color(0xFF245859), label = "Minggu Kemarin")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            ProgressBarRow(label = "penyelesaian kelas", progressThisWeek = 0.7f, progressLastWeek = 0.5f)
            Spacer(modifier = Modifier.height(8.dp))
            ProgressBarRow(label = "penyelesaian Tugas", progressThisWeek = 0.9f, progressLastWeek = 0.4f)

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "1 November - 28 November 2024",
                style = TextStyle(fontSize = 12.sp, color = Color.Black)
            )
        }
    }
}

@Composable
fun LegendItem(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
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
                val barHeight = 20.dp.toPx()
                val cornerRadius = CornerRadius(4.dp.toPx())


                drawRoundRect(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    size = Size(size.width, barHeight),
                    cornerRadius = cornerRadius
                )

                drawRoundRect(
                    color = Color(0xFF006769),
                    size = Size(size.width * progressLastWeek, barHeight),
                    cornerRadius = cornerRadius
                )

                drawRoundRect(
                    color = Color(0xFF8FD3C1),
                    size = Size(size.width * progressThisWeek, barHeight),
                    cornerRadius = cornerRadius,
//                    style = Stroke(width = 4.dp.toPx())
                )
            }
        }
    }
}


@Composable
fun ImageBanner() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.imagebanner),
                contentDescription = "Image desain grafis",
                modifier = Modifier
                    .height(180.dp)
                    .width(440.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EdugoAppPreview() {
//    BerandaScreen(navController = rememberNavController())
//}

