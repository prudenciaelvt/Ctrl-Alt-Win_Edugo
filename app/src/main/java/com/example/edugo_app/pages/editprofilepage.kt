package com.example.edugo_app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.edugo_app.AppTopBar
import com.example.edugo_app.R

@Composable
fun EditProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBarEditProfile(navController) }
    ) { paddingValues ->
        EditProfileContent(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF))
                .padding(paddingValues),
            navController = navController,
            onBackClick = { navController.popBackStack() }
        )
    }
}

@Composable
fun TopBarEditProfile(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF006769))
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.popBackStack() }
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Riwayat Tugas",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun EditProfileContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

        Spacer(modifier = Modifier.height(16.dp))

        Profile2Button(
            text = "User Edugo",
            iconResId = R.drawable.iconprofile,
            backgroundColor = Color.White
        ) {}
        Profile2Button(
            text = "1 DKV",
            iconResId = R.drawable.ic_academic_cap,
            backgroundColor = Color.White,
        ) {}
        Profile2Button(
            text = "22 September 2008",
            iconResId = R.drawable.iconcalender,
            backgroundColor = Color.White
        ) {}
        Profile2Button(
            text = "user@siswa.id",
            iconResId = R.drawable.ic_mail,
            backgroundColor = Color.White
        ) {}
        Profile2Button(
            text = "08123456789",
            iconResId = R.drawable.ic_phone,
            backgroundColor = Color.White
        ) {}
        Profile2Button(
            text = "Simpan Perubahan",
            iconResId = R.drawable.icondownload,
            backgroundColor = Color(0xFF006769),
            textColor = Color.White
        ) { onBackClick() }
    }
}

@Composable
fun Profile2Button(
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
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp
        )
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
                modifier = Modifier
                    .size(
                        if (iconResId == R.drawable.ic_academic_cap ||
                            iconResId == R.drawable.ic_phone ||
                            iconResId == R.drawable.ic_mail
                        ) {
                            24.dp
                        } else {
                            18.dp
                        }
                    ),
                colorFilter = if (iconResId == R.drawable.icondownload) {
                    ColorFilter.tint(Color.White)
                } else {
                    ColorFilter.tint(Color.Black)
                }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = text,
                color = textColor,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


