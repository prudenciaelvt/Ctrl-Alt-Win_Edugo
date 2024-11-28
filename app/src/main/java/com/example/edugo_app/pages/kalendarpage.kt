package com.example.edugo_app.pages

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.rememberNavController

@Composable
fun KalenderScreen() {
    Column {
        KalenderView()
        KalenderTask()
    }
}

@Composable
fun KalenderView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            modifier = Modifier
                .width(330.dp)
                .height(320.dp)
                .shadow(8.dp, shape = RoundedCornerShape(16.dp), clip = true)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White),
            factory = { context ->
                CalendarView(context)
            }
        )
    }
}

@Composable
fun KalenderTask() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(400.dp)
            .shadow(8.dp, shape = RoundedCornerShape(16.dp), clip = true)
            .clip(RoundedCornerShape(16.dp))
        .background(Color(0xFF7FB5A1)),
        contentAlignment = Alignment.Center

    ) {
        ScheduleData(navController = rememberNavController())
    }
}

