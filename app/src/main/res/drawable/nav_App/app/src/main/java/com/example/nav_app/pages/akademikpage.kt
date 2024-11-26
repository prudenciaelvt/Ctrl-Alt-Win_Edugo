package com.example.nav_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nav_app.AkademikTopBar
import com.example.nav_app.R
import com.example.nav_app.data.graphicDesignCard
import com.example.nav_app.data.matematikaCard
import com.example.nav_app.data.lessoncard
import com.example.nav_app.navApp

@Composable
fun AkademikScreen(subjectCards: List<lessoncard>) {
    Surface(
        modifier = Modifier.background(Color(0xFF13382C))
    ) {
        Column {
            AkademikTopBar(currentRoute = "Akademik")
            KelasContent(navController = rememberNavController())
            MateriContent(subjectCards = subjectCards)
            KelasVirtualContent()
            SampleScheduleCard()
        }
    }
}

@Composable
fun KelasContent(navController: NavController) {
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
            TextButton(onClick = { navController.navigate("semuakelaspage") }) {
                Text(text = "Semuanya >", color = Color.Black, fontSize = 14.sp)
            }

        }
        Spacer(modifier = Modifier.height(6.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 1.dp)
        ) {
            val categories = listOf("1DKV", "2ATPH", "3ATU", "4ATPH", "5DKV")
            items(categories) { category ->
                Box(
                    modifier = Modifier
                        .background(Color(0xFF006769), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                        .clickable { /* TODO: Add onClick action */ }
                ) {
                    Text(text = category, color = Color(0xFF5B8C51), fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun MateriContent(subjectCards: List<lessoncard>) {
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
            TextButton(onClick = { /* TODO: Add detail action */ }) {
                Text(text = "Semuanya >", color = Color.Black, fontSize = 14.sp)
            }
        }
        MateriCardsRow(subjectCards = subjectCards)
    }
}

@Composable
fun MateriCardsRow(subjectCards: List<lessoncard>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(subjectCards) { card ->
            MateriCardItem(card)
        }
    }
}

@Composable
fun MateriCardItem(card: lessoncard) {
    Card(
        modifier = Modifier
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
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
            Text(text = card.persentase, style = TextStyle(fontSize = 12.sp))
            Text(text = card.score, style = TextStyle(fontSize = 12.sp))
        }
    }
}

@Composable
fun KelasVirtualContent( ) {
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
            TextButton(onClick = { /* TODO: Add detail action */ }) {
                Text(text = "Semuanya >", color = Color.Black, fontSize = 14.sp)
            }
        }


    }
}

@Composable
fun SampleScheduleCard() {
    ScheduleCard(
        course = "Graphic design 1",
        classCode = "1 DKV",
        schedule = "Selasa, 13.00 - 14.00 Wib",
        onClick = { /* Handle click */ }
    )
}

@Composable
fun ScheduleCard(
    course: String,
    classCode: String,
    schedule: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF006769))
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = course,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = classCode,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = schedule,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .height(36.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Lihat", color = Color(0xFF006769))
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun NavappPreview() {
//    val subjectCards = listOf(graphicDesignCard, matematikaCard)
//    AkademikScreen(subjectCards = subjectCards)
//}
