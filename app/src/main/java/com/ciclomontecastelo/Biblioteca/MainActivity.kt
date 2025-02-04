package com.ciclomontecastelo.Biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciclomontecastelo.Biblioteca.ui.theme.BibliotecaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BibliotecaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InterfazUsuario(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuario(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Biblioteca Comunitaria") }
            )
        },
        content = { padding ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Text(
                    text = "Bienvenido a la Biblioteca Comunitaria",
                    modifier = Modifier.padding(16.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.library),
                    contentDescription = "Imagen de la Biblioteca",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp)
                )

                val libros = listOf(
                    "Don Quijote de la Mancha",
                    "Cien años de soledad",
                    "La sombra del viento",
                    "El amor en los tiempos del cólera",
                    "Crónica de una muerte anunciada"
                )

                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(libros) { libro ->
                        Text(
                            text = libro,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun InterfazUsuarioPreview() {
    BibliotecaTheme {
        InterfazUsuario()
    }
}
