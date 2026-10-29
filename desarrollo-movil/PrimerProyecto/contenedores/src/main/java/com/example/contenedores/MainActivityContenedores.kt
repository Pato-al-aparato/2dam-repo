package com.example.contenedores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Text("Primero")
    Text("Segundo")
}

@Preview(showBackground = true)
@Composable
fun MiContenedorPreview() {
    PrimerProyectoTheme {
        MiContenedor("Android")
    }
}