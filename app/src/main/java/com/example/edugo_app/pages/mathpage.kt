package com.example.edugo_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.edugo_app.R
import com.example.edugo_app.data.lessoncard

@Composable
fun mathscreen(subjectCards: List<lessoncard>, navController: NavController.Companion) {
    Surface(
        modifier = Modifier.background(Color(0xFF13382C))
    ) {
        Column {
           MathContent(subjectCards = subjectCards)

        }
    }
}

@Composable
fun MathContent(subjectCards: List<lessoncard>) {
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
        MathCardsRow(subjectCards = subjectCards)
    }
}

@Composable
fun MathCardsRow(subjectCards: List<lessoncard>) {
    repeat(3) {
        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(subjectCards) { card ->
                MathCardItem(card)
            }
        }
    }

}


@Composable
fun MathCardItem(card: lessoncard) {
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
