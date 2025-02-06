package com.ciclomontecastelo.Biblioteca

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciclomontecastelo.Biblioteca.ui.theme.BibliotecaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: BibliotecaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BibliotecaTheme {
                InterfazUsuario(viewModel)
            }
        }
        Log.d("CicloDeVida", "Activity creada (onCreate)")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuario(viewModel: BibliotecaViewModel) {
    val libros by viewModel.libros.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Biblioteca Comunitaria") }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                if (libros.isEmpty()) {
                    Text("No hay libros disponibles")
                } else {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        items(libros) { libro ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Text(
                                    text = "${libro.titulo} - ${libro.autor} - ${libro.genero} - Disponible: ${libro.disponible}",
                                    modifier = Modifier.weight(1f)
                                )
                                Button(
                                    onClick = { viewModel.eliminarLibro(libro) }  // Pasar el objeto Libro
                                ) {
                                    Text("Eliminar")
                                }
                            }
                        }
                    }
                }

                Button(
                    onClick = { viewModel.insertarLibro(Libro(titulo = "El gran Gatsby", autor = "F. Scott Fitzgerald", genero = "Ficción", disponible = true)) },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Añadir libro de prueba")
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun InterfazUsuarioPreview() {
    BibliotecaTheme {
        // Proveer un ViewModel mock para la previsualización
    }
}
