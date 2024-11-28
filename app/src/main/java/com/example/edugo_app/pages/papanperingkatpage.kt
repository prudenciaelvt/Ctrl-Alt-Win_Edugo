package com.example.edugo_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.edugo_app.R

@Composable
fun PapanPeringkatScreen(navController: NavHostController = rememberNavController()) {
    PapanPeringkatContent(navController = navController)
}

@Composable
fun PapanPeringkatContent(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header section
        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(Color(0xFF006769)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.iconwinning),
                contentDescription = "Icon winning",
                modifier = Modifier
                    .size(360.dp)
            )
        }
        Box(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
                .background(Color(0xFF006769))
        )

        // Leaderboard data
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            PeringkatData(navController = navController)
        }
    }
}

@Composable
fun PeringkatData(navController: NavHostController) {
    val peringkatList = listOf(
        Peringkat(R.drawable.image1, "Satria", "700 Points"),
        Peringkat(R.drawable.image2, "Andini", "650 Points"),
        Peringkat(R.drawable.image3, "Budi", "620 Points"),
        Peringkat(R.drawable.image4, "Citra", "600 Points")
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(peringkatList) { peringkat ->
            PeringkatCard(
                imageUser = peringkat.imageUser,
                name = peringkat.name,
                point = peringkat.point
            )
        }
    }
}

data class Peringkat(
    val imageUser: Int,
    val name: String,
    val point: String
)

@Composable
fun PeringkatCard(
    imageUser: Int,
    name: String,
    point: String
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
            .fillMaxWidth(),
    shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.iconnumber),
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 16.dp)
            )
            Image(
                painter = painterResource(id = imageUser),
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(70.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = point,
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

@Preview(showBackground = true)
@Composable
fun PapanPeringkatPreview() {
    PapanPeringkatScreen()
}
