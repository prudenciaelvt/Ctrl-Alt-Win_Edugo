package com.example.edugo_app.pages

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.AkademikTopBar
import com.example.edugo_app.R
import com.example.edugo_app.data.CardUser
import com.example.edugo_app.data.desainGrafisCard
import com.example.edugo_app.data.lessoncard
import com.example.edugo_app.data.matematikaCard
import javax.security.auth.Subject

@Composable
fun AkademikScreen(subjectCards: List<lessoncard>) {
    Surface(
        modifier = Modifier.background(Color(0xFF13382C))
    ) {
        Column {
            AkademikTopBar(currentRoute = "Akademi")
            KelasContent(navController = rememberNavController() )
            MateriContent(subjectCards = subjectCards)
            KelasVirtualContent()

        }
    }
}

@Composable
fun KelasContent(
    navController: NavHostController
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Row (
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
                onClick = { navController.navigate("SemuaKelasScreen") }
            ) {
                Text(
                    text = "Semuanya >",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
        }
            Spacer(modifier = Modifier.height(6.dp))
            LazyRow (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 1.dp)
            ){
                val categories = listOf("1DKV", "2ATPH", "3ATU", "4ATPH", "6DKV")
                items(categories) { category ->
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF006769), shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 20.dp, vertical = 8.dp)
                            .clickable {  }
                    ) {
                        Text(
                            text = category,
                            color = Color(0xFF5B8C51),
                            fontSize = 12.sp
                        )
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
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
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
fun KelasVirtualContent() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
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
            TextButton(
                onClick = { }
            ) {
                Text(
                    text = "Semuanya >",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(6.dp))
        LazyRow (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 1.dp)
        ){
            val categories = listOf("Semua", "Sekarang", "Besok", "Mendatang")
            items(categories) { category ->
                Box(
                    modifier = Modifier
                        .background(Color(0xFF006769), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 20.dp, vertical = 8.dp)
                        .clickable {  }
                ) {
                    Text(
                        text = category,
                        color = Color(0xFF5B8C51),
                        fontSize = 12.sp
                    )
                }

            }
        }

    }
}
