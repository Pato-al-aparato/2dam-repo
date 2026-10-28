package com.example.primerproyecto

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primerproyecto.ui.theme.PrimerProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerProyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(48.dp)
            //.fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
            //.border(8.dp,Color.DarkGray),
        //fontSize = 48.sp,
        //fontWeight = FontWeight.SemiBold,
        //color = Color.White
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.onSecondary

    )
}

@Preview(
    showBackground = true,
    showSystemUi = false,
    name = "Tema claro")
@Composable
fun GreetingPreview() {
    PrimerProyectoTheme {
        Greeting("Android")
    }
}