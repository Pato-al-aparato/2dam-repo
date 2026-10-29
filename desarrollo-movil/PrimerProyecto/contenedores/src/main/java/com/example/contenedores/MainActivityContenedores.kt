package com.example.contenedores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    Row (
        modifier = Modifier.fillMaxSize().padding(48.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("Primero")
        Text("Segundo")
        Text("Tercero")
    }

}

@Preview(showBackground = true ,showSystemUi = true)
@Composable
fun MiContenedorPreview() {
    PrimerProyectoTheme {
        MiContenedor()
    }
}