package com.example.edugo_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.AppTopBar
import com.example.edugo_app.data.SemuaKelasGrid
import com.example.edugo_app.data.getSemuaKelasGridItems

@Composable
fun SemuaKelasScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            KelasGrid(
                gridItems = getSemuaKelasGridItems(),
            )
            PelajaranGrid()
        }
    }
}




@Composable
fun KelasGrid(gridItems: List<SemuaKelasGrid>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(gridItems) { item ->
            KelasCard(item)

        }
    }
}

@Composable
fun KelasCard(item: SemuaKelasGrid) {
    Card (
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .size(100.dp)
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().background(Color(0xFF006769))
        ) {
            Column {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = "Subject Image",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = item.label,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White

                    )
                )
            }
        }
    }
}

@Composable
fun PelajaranGrid() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Pelajaran",
            style = TextStyle (
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        LessonGrid()
    }
}

data class Lesson(
    val title: String
)

@Composable
fun LessonGrid() {
    val lessons = listOf(
        Lesson("Matematika"),
        Lesson("Bahasa Ingriss"),
        Lesson("Bahasa Indonesia"),
        Lesson("Komunikasi"),
        Lesson("Fotografi"),
        Lesson("Tanaman"),
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
    ) {
        items(lessons) { lesson ->
            LessonItem(
                title = lesson.title,
                onClick = { }
            )
        }
    }
}

@Composable
fun LessonItem(title: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(8.dp)
            .clickable (onClick = onClick)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xff006769))
            .width(100.dp)
            .height(80.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}



@Preview(showBackground = true)
@Composable
fun EdugoAppPreview() {
    val navController = rememberNavController()
    SemuaKelasScreen(navController = navController)
}
