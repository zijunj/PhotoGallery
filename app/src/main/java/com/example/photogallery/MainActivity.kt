package com.example.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.photogallery.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoGalleryScreen()
        }
    }
}

@Composable
fun PhotoGalleryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray) // Added background color
            .padding(20.dp)
            .size(200.dp)
    ) {
        Text(
            text = "Valorant Agent Photo Gallery",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 50.dp, top = 50.dp)
        )

        Column {
            for (row in 0 until 2) { // 2 rows
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    for (col in 0 until 3) { // 3 columns
                        val index = row * 3 + col
                        PhotoItem(imageRes = getImageResource(index), caption = getCaption(index))
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))

            }

        }
    }
}

@Composable
fun PhotoItem(imageRes: Int, caption: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
    ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = caption,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
                    .fillMaxSize()
                    .aspectRatio(1f) // Keeps images square
            )
            Text(text = caption, fontSize = 20.sp, fontWeight = FontWeight.Medium)
        }
    }


fun getImageResource(index: Int): Int {
    return when (index) {
        0 -> R.drawable.jett
        1 -> R.drawable.omen
        2 -> R.drawable.brimstone
        3 -> R.drawable.raze
        4 -> R.drawable.sova
        5 -> R.drawable.tejo
        else -> R.drawable.jett
    }
}

fun getCaption(index: Int): String {
    return when (index) {
        0 -> "Jett"
        1 -> "Omen"
        2 -> "Brimstone"
        3 -> "Raze"
        4 -> "Sova"
        5 -> "Tejo"
        else -> "Unknown"
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPhotoGalleryScreen() {
    PhotoGalleryScreen()
}
