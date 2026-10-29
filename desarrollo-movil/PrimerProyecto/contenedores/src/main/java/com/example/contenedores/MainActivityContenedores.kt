package com.example.contenedores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contenedores.ui.theme.PrimerProyectoTheme

class MainActivityContenedores : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerProyectoTheme {
                    MiContenedor()

            }
        }
    }
}

@Composable
fun MiContenedor() {
//    Column(
//        modifier = Modifier.fillMaxSize().padding(48.dp),
//        verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.Start,
//        ) {
//        Text("Primero")
//        Text("Segundo")
//        Text("Tercero")
//    }

//    Row (
//        modifier = Modifier.fillMaxSize().padding(48.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Text("Primero", modifier = Modifier.background(color = Color.Green))
//        Text("Segundo", modifier = Modifier.background(MaterialTheme.colorScheme.primary))
//        Text("Tercero")
//        Text("Cuarto")
//    }
//
//    Box(
//        modifier = Modifier.size(120.dp).background(Color.Yellow),
//        contentAlignment = Alignment.Center
//    ){
//        Text("Centro")
//        Text("Abajo", modifier = Modifier.align(Alignment.BottomEnd))
//    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text("1/3", modifier = Modifier
            .weight(15f)
            .background(Color.Green)
            .fillMaxSize())

        Text("2/3", modifier = Modifier
            .weight(15f)
            .background(Color.Blue))
    }



}

@Preview(showBackground = true ,showSystemUi = true)
@Composable
fun MiContenedorPreview() {
    PrimerProyectoTheme {
        MiContenedor()
    }
}