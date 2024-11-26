package com.example.edugo_app.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.edugo_app.R

@Composable
fun ForumContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .background(Color(0xFFEFEFEF))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icontugas),
                contentDescription = "Tulis",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Mulai Berdiskusi",
                style = TextStyle(color = Color.Gray, fontSize = 16.sp)
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                ForumItem(
                    name = "Belva",
                    message = "Permisi teman teman ada yang bisa bantu saya dalam memberi referensi warna untuk desain ",
                    replyCount = 5,
                    profileImageRes = R.drawable.image1
                )
            }
            item {
                ForumItem(
                    name = "Sulfia",
                    message = "Permisi teman teman ada yang bisa bantu saya untuk tugas desain 3D",
                    replyCount = 3,
                    profileImageRes = R.drawable.image2
                )
            }
            item {
                ForumItem(
                    name = "Ferdian",
                    message = "guys gimana ya utk pengumpulan tgs desain?",
                    replyCount = 9,
                    profileImageRes = R.drawable.imageprofile,
                    contentImageRes = R.drawable.imagedesaingrafis,
                )
            }
            item {
                ForumItem(
                    name = "Ridwan",
                    message = "Permisi teman teman ada yang bisa bantu saya untuk tugas desain 3D",
                    replyCount = 3,
                    profileImageRes = R.drawable.imageprofile
                )
            }
        }
    }
}

@Composable
fun ForumItem(
    name: String,
    message: String,
    replyCount: Int,
    profileImageRes: Int,
    contentImageRes: Int? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(profileImageRes),
                contentDescription = "Profile Picture",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(name, style = TextStyle(fontSize = 18.sp, color = Color.Black))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(message, style = TextStyle(fontSize = 16.sp, color = Color.Gray))
        if (contentImageRes != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Icon(
                painter = painterResource(contentImageRes),
                contentDescription = "Content Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(8.dp))
        Text("$replyCount Balasan", style = TextStyle(fontSize = 14.sp, color = Color.Gray))
    }
}