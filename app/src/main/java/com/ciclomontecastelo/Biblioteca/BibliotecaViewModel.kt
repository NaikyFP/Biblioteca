package com.ciclomontecastelo.Biblioteca

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BibliotecaViewModel(private val repository: BibliotecaRepository) : ViewModel() {

    private val _libros = MutableStateFlow<List<Libro>>(emptyList())
    val libros: StateFlow<List<Libro>> get() = _libros

    init {
        fetchLibros()
    }

    private fun fetchLibros() {
        viewModelScope.launch {
            val fetchedLibros = repository.obtenerTodosLosLibros()
            _libros.value = fetchedLibros
        }
    }

    fun insertarLibro(libro: Libro) {
        viewModelScope.launch {
            repository.insertarLibro(libro)
            fetchLibros() // Refrescar los datos
        }
    }

    fun eliminarLibro(libro: Libro) {
        viewModelScope.launch {
            repository.eliminarLibro(libro)
            fetchLibros() // Refrescar los datos
        }
    }
}
