package com.example.nav_app.pages

import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

package com.example.nav_app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nav_app.R

@Composable
fun ScheduleCard(
    courseTitle: String,
    classCode: String,
    schedule: String
) {
    Card(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF006769)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = courseTitle,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = classCode,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = schedule,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White
                    )
                )
            }
            Button(
                onClick = { /* Handle button click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(text = "Lihat", color = Color(0xFF006769))
            }
        }
    }
}

@Composable
fun SampleScheduleCard1() {
    ScheduleCard(
        courseTitle = "Graphic design 1",
        classCode = "1 DKV",
        schedule = "Selasa, 13.00 - 14.00 Wib"
    )
}


@Preview(showBackground = true)
@Composable
fun NavappPreview() {
    SampleScheduleCard1()
}

