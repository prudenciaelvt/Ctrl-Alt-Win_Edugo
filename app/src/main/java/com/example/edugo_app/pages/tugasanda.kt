package com.example.edugo_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.edugo_app.R

@Composable
fun TugasAndaPage(navController: NavHostController) {
    Scaffold(
        topBar = { TopBarTugasAnda(navController) },
        bottomBar = {
            UploadButton()
        }
    ) { paddingValues ->
        TugasAndaContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            navController = navController
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TugasAndaContent(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.imagedesaingrafis),
            contentDescription = "Gambar Matematika",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Matematika",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Waktu Pengumpulan: 22 November 2024",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "Jam: 17:00 WIB",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "Status: Belum Dikumpulkan",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Deskripsi",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = """
Kerjakan soal-soal berikut dengan cermat dan teliti:
Sebuah toko menjual 120 kg beras dalam waktu 6 hari. Jika toko tersebut ingin menjual 200 kg beras dengan kecepatan yang sama, berapa hari yang diperlukan?
Hitung luas sebuah lingkaran dengan diameter 28 cm.
...
Tata cara pengumpulan:
Jawaban harus dikumpulkan dalam bentuk PDF.
Sertakan langkah-langkah penyelesaian untuk setiap soal.
            """.trimIndent(),
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Composable
fun UploadButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF006769))
            .clickable {
            }
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.upload),
                contentDescription = "Upload Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {}
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Upload File Anda",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )
        }

    }
}

@Composable
fun TopBarTugasAnda(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF006769))
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Tugas Anda",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
