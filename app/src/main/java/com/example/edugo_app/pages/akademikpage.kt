package com.example.edugo_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.R
import com.example.edugo_app.data.Schedule
import com.example.edugo_app.data.desainGrafisCard
import com.example.edugo_app.data.lessoncard
import com.example.edugo_app.data.matematikaCard
import com.example.edugo_app.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AkademikScreen(subjectCards: List<lessoncard>, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        KelasContent(navController = navController)
        MateriContent(subjectCards = subjectCards, navController)
        KelasVirtualContent(
            courseTitle = "Graphic Design 1",
            classCode = "1 DKV",
            schedule = "Selasa, 13.00 - 14.00 WIB"
        )
        ScheduleData(navController)
    }
}


@Composable
fun KelasContent(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Kelas",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            TextButton(
                onClick = { navController.navigate(Screen.SemuaKelas.route) }
            ) {
                Text(
                    text = "Semuanya >",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            val categories = listOf("1DKV", "2ATPH", "3ATU", "4ATPH", "6DKV")
            items(categories) { category ->
                Box(
                    modifier = Modifier
                        .background(Color(0xFF006769), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                        .clickable { }
                ) {
                    Text(
                        text = category,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}


@Composable
fun MateriContent(subjectCards: List<lessoncard>, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Materi",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        MateriCardsRow(subjectCards = subjectCards, navController = navController)
    }
}

@Composable
fun MateriCardsRow(
    subjectCards: List<lessoncard>,
    navController: NavController
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        items(subjectCards) { card ->
            MateriCardItem(card = card, navController = navController)
        }
    }
}


@Composable
fun MateriCardItem(
    card: lessoncard,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
            .clickable {
                navController.navigate(Screen.Materi.route)
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
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
            Text(
                text = card.judul,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = card.classCode, style = TextStyle(fontSize = 12.sp))
                Text(text = card.jumlahsiswa, style = TextStyle(fontSize = 12.sp))
                Text(text = card.jumlahtugas, style = TextStyle(fontSize = 12.sp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = card.persentase, style = TextStyle(fontSize = 12.sp))
                Text(text = card.score, style = TextStyle(fontSize = 12.sp))
            }
            Image(
                painter = painterResource(id = R.drawable.iconprogress),
                contentDescription = "Progress",
            )
        }
    }
}



@Composable
fun KelasVirtualContent(
    courseTitle: String,
    classCode: String,
    schedule: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Kelas Virtual",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 1.dp)
        ) {
            val categories = listOf("Semua", "Sekarang", "Besok", "Mendatang")
            items(categories) { category ->
                Box(
                    modifier = Modifier
                        .background(Color(0xFF006769), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                        .clickable { }
                ) {
                    Text(
                        text = category,
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ScheduleData(navController: NavHostController) {
    val scheduleList = listOf(
        Schedule("Graphic Design 1", "1 DKV", "Selasa, 13.00 - 14.00 WIB"),
        Schedule("Graphic Design 2", "2 DKV", "Rabu, 10.00 - 11.00 WIB"),
        Schedule("Matematika", "3 SMA", "Kamis, 08.00 - 09.00 WIB")
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(scheduleList) { schedule ->
            ScheduleCard(
                courseTitle = schedule.courseTitle,
                classCode = schedule.classCode,
                schedule = schedule.schedule,
                navController = navController
            )
        }
    }
}


@Composable
fun ScheduleCard(
    courseTitle: String,
    classCode: String,
    schedule: String,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF006769)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = courseTitle,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = classCode,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = schedule,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }
            Button(
                onClick = { navController.navigate(Screen.KelasDesain.route) },
                colors = ButtonDefaults.buttonColors(containerColor =
                Color.White)
            ) {
                Text(text = "Lihat", color = Color(0xFF006769))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun NavappPreview() {
    val sampleLessonCards = listOf(desainGrafisCard, matematikaCard)

    AkademikScreen(
        subjectCards = sampleLessonCards,
        navController = rememberNavController()
    )
}


