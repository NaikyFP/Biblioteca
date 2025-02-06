package com.ciclomontecastelo.Biblioteca

class BibliotecaRepository(private val libroDao: LibroDao) {

    suspend fun obtenerTodosLosLibros(): List<Libro> {
        return libroDao.obtenerTodosLosLibros()
    }

    suspend fun insertarLibro(libro: Libro) {
        libroDao.insertarLibro(libro)
    }

    suspend fun eliminarLibro(libro: Libro) {
        libroDao.eliminarLibro(libro)
    }
}
