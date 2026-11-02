package com.example.labo2_partie2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labo2_partie2.ui.theme.Labo2_Partie2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo2_Partie2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtwork by remember { mutableIntStateOf(1) }

    val imageResource = when (currentArtwork) {
        1 -> R.drawable.artwork1
        2 -> R.drawable.artwork2
        else -> R.drawable.artwork3
    }

    val titleResource = when (currentArtwork) {
        1 -> R.string.artwork_title_1
        2 -> R.string.artwork_title_2
        else -> R.string.artwork_title_3
    }

    val artistResource = when (currentArtwork) {
        1 -> R.string.artwork_artist_1
        2 -> R.string.artwork_artist_2
        else -> R.string.artwork_artist_3
    }

    val yearResource = when (currentArtwork) {
        1 -> R.string.artwork_year_1
        2 -> R.string.artwork_year_2
        else -> R.string.artwork_year_3
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Surface(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            shadowElevation = 8.dp,
            color = Color.White
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = titleResource),
                modifier = Modifier.padding(32.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFECEFF1))
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = titleResource),
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Text(
                    text = stringResource(id = artistResource),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = " (${stringResource(id = yearResource)})",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentArtwork == 1) currentArtwork = 3 else currentArtwork--
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (currentArtwork == 3) currentArtwork = 1 else currentArtwork++
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    Labo2_Partie2Theme {
        ArtSpaceApp()
    }
}