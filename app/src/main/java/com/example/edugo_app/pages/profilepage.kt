package com.example.edugo_app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.edugo_app.R

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Scaffold(

    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF))
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.imageprofile),
                contentDescription = "User Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Informasi pengguna
            Text(text = "User Edugo", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Kelas: 1 DKV", fontSize = 16.sp, color = Color.Gray)
            Text(text = "ferdi@siswa.id", fontSize = 16.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(24.dp))

            ProfileButton(
                text = "Edit Profil",
                iconResId = R.drawable.iconprofile,
                backgroundColor = Color.White // Pastikan ini adalah Color.White
            ) {
                // Action for Edit Profile
            }
            ProfileButton(
                text = "Riwayat Kelas",
                iconResId = R.drawable.iconakademik,
                backgroundColor = Color.White // Pastikan ini adalah Color.White
            ) {
                // Action for Class History
            }
            ProfileButton(
                text = "Riwayat Aktivitas Penilaian",
                iconResId = R.drawable.iconakademik,
                backgroundColor = Color.White // Pastikan ini adalah Color.White
            ) {
                // Action for Assessment Activity History
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Tombol Keluar
            ProfileButton(
                text = "Keluar",
                iconResId = R.drawable.iconberanda,
                backgroundColor = Color(0xFF006769),
                textColor = Color.White
            ) {
                // Action for Logout
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ProfileTopBar() {
//    TopAppBar(
//        title = {
//            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.Center
//            ) {
//                Text("Profil", color = Color.White)
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = Color(0xFF006769)
//        )
//    )
//}

@Composable
fun ProfileButton(
    text: String,
    iconResId: Int,
    backgroundColor: Color,
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Gunakan tint untuk mengubah warna ikon
            androidx.compose.foundation.Image(
                painter = painterResource(id = iconResId),
                contentDescription = "Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 16.dp),
                colorFilter = ColorFilter.tint(Color.Black) // Ubah warna ikon menjadi hitam
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = text, color = textColor, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}