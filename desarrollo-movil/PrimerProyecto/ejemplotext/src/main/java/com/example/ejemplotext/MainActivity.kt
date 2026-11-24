package com.example.ejemplotext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplotext.ui.theme.PrimerProyectoTheme



@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PrimerProyectoTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "DEMO TEXTVIEW",
                                    color = Color.White
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Blue
                            )
                        )
                    }
                ) { innerPadding ->

                    PantallaEjemplos(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun PantallaEjemplos(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Ejemplos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "\n1. Cambiar color",
            fontSize = 22.sp
        )

        Text(
            text = "Texto color verde azulado",
            color = Color(0xFF008080)
        )

        Text(
            text = "\n2. Cambiar tamaño",
            fontSize = 22.sp
        )

        Text("Tamaño de 14sp", fontSize = 14.sp)
        Text("Tamaño de 16sp", fontSize = 16.sp)
        Text("Tamaño de 20sp", fontSize = 20.sp)
        Text("Tamaño de 24sp", fontSize = 24.sp)

        Text(
            text = "\n3. Cambiar estilo de fuente",
            fontSize = 22.sp
        )

        Text("Estilo normal")

        Text(
            text = "Estilo en negrita",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Estilo cursiva",
            fontStyle = FontStyle.Italic
        )

        Text(
            text = "Estilo cursiva y negrita",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        Text(
            text = "\n4. Cambiar tipo de fuente",
            fontSize = 22.sp
        )

        Text(
            text = "Fuente Sans Serif",
            fontFamily = FontFamily.SansSerif
        )

        Text(
            text = "Fuente Serif",
            fontFamily = FontFamily.Serif
        )

        Text(
            text = "Fuente Monospace",
            fontFamily = FontFamily.Monospace
        )

        Text(
            text = "\n5. Convertir URLs en links clickables",
            fontSize = 22.sp
        )

        Text(
            text = "https://www.google.com",
            color = Color.Blue
        )

        Text(
            text = "\n6. Convertir a mayúsculas",
            fontSize = 22.sp
        )

        Text(
            text = "Texto convertido a mayúsculas".uppercase()
        )

        Text(
            text = "\n7. Cambiar familia tipográfica",
            fontSize = 22.sp
        )

        Text("Sans Serif", fontFamily = FontFamily.SansSerif)
        Text("Serif", fontFamily = FontFamily.Serif)
        Text("Monospace", fontFamily = FontFamily.Monospace)
        Text("Cursive", fontFamily = FontFamily.Cursive)
    }
}