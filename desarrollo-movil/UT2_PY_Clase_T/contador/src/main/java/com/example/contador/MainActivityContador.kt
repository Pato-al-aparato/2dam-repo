package com.example.contador

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contador.ui.theme.UT2_PY_Clase_TTheme

class MainActivityContador : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaContador()
        }
    }
}

@Composable
fun Contador(modifier: Modifier = Modifier) {
    var contador by remember { mutableIntStateOf(0) }
    Column(modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Contador de Dragos", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(32.dp))
        Text("$contador", style = MaterialTheme.typography.displayLarge)

        Spacer(Modifier.height(32.dp))

        Row() {
            Button(onClick = {contador++}) {
                Text("Sumar")
            }

            Button(onClick = {contador--}) {
                Text("Restar")
            }
        }


        OutlinedButton(onClick = {contador = 0}) {
            Text("Reiniciar")
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContadorPreview() {
    UT2_PY_Clase_TTheme {
        PantallaContador()
    }
}

@Composable
private fun PantallaContador() {
    UT2_PY_Clase_TTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Contador(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
