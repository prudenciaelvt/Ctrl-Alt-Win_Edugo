package com.example.edugo_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import com.example.edugo_app.R

@Composable
fun KelasDesainScreen() {
    KelasDesainContent()
}

@Composable
fun KelasDesainContent() {
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
                painter = painterResource(id = R.drawable.imagedesaingrafis),
                contentDescription = "Image desain grafis",
                modifier = Modifier
                    .height(180.dp)
                    .width(340.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(8.dp, shape = RoundedCornerShape(16.dp), clip = true)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF006769))
                    .padding(16.dp), // Padding inside the box
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = "Graphic Desain 2",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Guru: Ferdi Susanto",
                        style = TextStyle(color = Color.White)
                    )
                    Text(
                        text = "Kelas: 2DKV",
                        style = TextStyle(color = Color.White)
                    )
                    Text(
                        text = "Hari/Tanggal: Rabu, 20 November 2024",
                        style = TextStyle(color = Color.White)
                    )
                    Text(
                        text = "Waktu: 13:00 WIB",
                        style = TextStyle(color = Color.White)
                    )
                    Text(
                        text = "Link Zoom: https://zoomdummy.com/j/1234567890?pwd=abcdef1234",
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KelasDesainPreview() {
    KelasDesainScreen()
}
