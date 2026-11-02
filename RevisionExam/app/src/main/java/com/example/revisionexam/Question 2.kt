package com.example.revisionexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.revisionexam.ui.theme.RevisionExamTheme

class Question2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RevisionExamTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp),
                    color = Color(37,150,190)
                ) {
                    EmptyLayout()
                }
            }
        }
    }
}

@Composable
fun EmptyLayout() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Surface (
            color = Color.Black,
            modifier = Modifier.weight(0.5f)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
            ) {
                Text(
                    text = stringResource(R.string.apple),
                    color = Color(100, 12, 0),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        }
        Surface(color = Color.Black, modifier = Modifier.weight(1f)) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth()
                .weight(2f)) {
                Text(
                    text = stringResource(R.string.apple2),
                    color = Color(100, 12, 0),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

            }
        }
        Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier =  Modifier.weight(10f).fillMaxWidth()){
            Image(painter = painterResource(R.drawable.seal), contentDescription = "seals", modifier = Modifier.weight(1f))
            Image(painter = painterResource(R.drawable.seal), contentDescription = "seals", modifier = Modifier.weight(4f))
            Image(painter = painterResource(R.drawable.seal), contentDescription = "seals", modifier = Modifier.weight(5f))
            Image(painter = painterResource(R.drawable.seal), contentDescription = "seals", modifier = Modifier.weight(1f))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun VideLayoutPreview() {
    RevisionExamTheme() {Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        color = Color(37, 150, 190)
    ){
        EmptyLayout()
    }
    }
}