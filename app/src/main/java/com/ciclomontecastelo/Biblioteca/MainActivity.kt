package com.ciclomontecastelo.Biblioteca

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ciclomontecastelo.Biblioteca.ui.theme.BibliotecaTheme

class MainActivity : ComponentActivity() {
    private lateinit var databaseManager: DatabaseManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        databaseManager = DatabaseManager(this)
        setContent {
            BibliotecaTheme {
                InterfazUsuario(databaseManager)
            }
        }
        Log.d("CicloDeVida", "Activity creada (onCreate)")
    }

    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "Activity iniciada (onStart)")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "Activity visible y en primer plano (onResume)")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "Activity en pausa (onPause)")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CicloDeVida", "Activity detenida (onStop)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "Activity destruida (onDestroy)")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("CicloDeVida", "Activity reiniciada (onRestart)")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("CicloDeVida", "Configuración cambiada (onConfigurationChanged)")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.d("CicloDeVida", "Poca memoria disponible (onLowMemory)")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterfazUsuario(databaseManager: DatabaseManager) {
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
                val libros = remember { mutableStateListOf<Libro>() }

                LaunchedEffect(Unit) {
                    val cursor = databaseManager.obtenerTodosLosLibros()
                    while (cursor.moveToNext()) {
                        val libro = Libro(
                            cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TITULO)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_AUTOR)),
                            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_GENERO)),
                            cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DISPONIBLE)) == 1
                        )
                        libros.add(libro)
                    }
                    cursor.close()
                }

                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(libros) { libro ->
                        Text(
                            text = "${libro.titulo} - ${libro.autor} - ${libro.genero} - Disponible: ${libro.disponible}",
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
        InterfazUsuario(DatabaseManager(LocalContext.current))
    }
}

