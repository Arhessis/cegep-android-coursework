package com.example.revisionexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.revisionexam.ui.theme.RevisionExamTheme

class Question3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RevisionExamTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp)
                ) {
                    EmptyLayout2()
                }
            }
        }
    }
}

@Composable
fun EmptyLayout2() {
    var v1 by remember { mutableIntStateOf(0) }
    var v2 by remember { mutableIntStateOf(0) }
    var answer by remember { mutableIntStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {

        Text ("Question 3 par George Georgiev")
        Text("V1 et V2 doivent etre entre 0 et 5")
        Text("V1 + V2 = ${answer.toString()}")

        Text("V1 : $v1")

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (v1 == 0 ) {
                Image(painterResource(R.drawable.red), "red", modifier = Modifier.size(100.dp))
                Action(v1, "V1 - 1", false, { v1 = v1 - 1 })
            } else {
                Image(painterResource(R.drawable.green), "red", modifier = Modifier.size(100.dp))
                Action(v1, "V1 - 1", true, { v1 = v1 - 1 })
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            if (v1 == 5 ) {
                Image(painterResource(R.drawable.red), stringResource(R.string.r), modifier = Modifier.size(100.dp))
                Action(v1, "V1 + 1", false, { v1 = v1 + 1 })
            } else {
                Image(painterResource(R.drawable.green), "green", modifier = Modifier.size(100.dp))
                Action(v1, "V1 + 1", true, { v1 = v1 + 1 })
            }
        }

        Text("V2 : $v2")

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            if (v2 == 0 ) {
                Image(painterResource(R.drawable.red), "red", modifier = Modifier.size(100.dp))
                Action(v2, "V2 - 1", false, { v2 = v2 - 1 })
            } else {
                Image(painterResource(R.drawable.green), "red", modifier = Modifier.size(100.dp))
                Action(v2, "V2 - 1", true, { v2 = v2 - 1 })
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (v2 == 5 ) {
                Image(painterResource(R.drawable.red), "red", modifier = Modifier.size(100.dp))
                Action(v2, "V2 + 1", false, { v2 = v2 + 1 })
            } else {
                Image(painterResource(R.drawable.green), "green", modifier = Modifier.size(100.dp))
                Action(v2, "V2 + 1", true, { v2 = v2 + 1 })
            }
        }

        answer = v1 + v2

    }
}

@Composable
fun Action(reponse : Int, description : String, actif : Boolean, action : () -> Unit) {
    Button(onClick = action, enabled = actif){
        Text(description)
    }
}

@Preview(showBackground = true)
@Composable
fun VideLayoutPreviewa() {
    RevisionExamTheme() {
        EmptyLayout2()
    }
}