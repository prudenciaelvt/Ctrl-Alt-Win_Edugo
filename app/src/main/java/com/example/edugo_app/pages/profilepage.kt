package com.example.edugo_app.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.edugo_app.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
    ) {
        ProfileContent(
            modifier = Modifier
                .fillMaxSize()

                .background(Color(0xFFFFFFFF)),
            navController = navController
        )
    }
}

@Composable
fun ProfileContent(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileButton(
            text = "Edit Profil",
            iconResId = R.drawable.iconprofile,
            backgroundColor = Color.White
        ) { navController.navigate("editprofile") }
        ProfileButton(
            text = "Riwayat Tugas",
            iconResId = R.drawable.ic_library,
            backgroundColor = Color.White
        ) { navController.navigate("riwayattugas") }
        ProfileButton(
            text = "Riwayat Aktivitas Forum",
            iconResId = R.drawable.ic_puzzle,
            backgroundColor = Color.White
        ) {}
        ProfileButton(
            text = "Log Out",
            iconResId = R.drawable.ic_logout,
            backgroundColor = Color(0xFF006769),
            textColor = Color.White
        ) {}
    }
}

@Composable
fun UserProfileHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.user_edugo),
            contentDescription = "User Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "User Edugo", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Kelas: 1 DKV", fontSize = 16.sp, color = Color.Gray)
        Text(text = "user@siswa.id", fontSize = 16.sp, color = Color.Gray)
    }
}

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
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = iconResId),
                contentDescription = "Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(18.dp),
                colorFilter = ColorFilter.tint(if (text == "Log Out") Color.White else Color.Black)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.ic_right),
                contentDescription = "Right Arrow",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(12.dp),
                colorFilter = ColorFilter.tint(if (text == "Log Out") Color.White else Color.Black)
            )
        }
    }
}
