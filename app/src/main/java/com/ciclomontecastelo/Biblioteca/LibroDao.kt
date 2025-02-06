package com.ciclomontecastelo.Biblioteca

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface LibroDao {

    @Insert
    suspend fun insertarLibro(libro: Libro)

    @Query("SELECT * FROM libros")
    suspend fun obtenerTodosLosLibros(): List<Libro>

    @Delete
    suspend fun eliminarLibro(libro: Libro)
}
