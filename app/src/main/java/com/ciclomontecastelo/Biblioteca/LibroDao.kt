package com.ciclomontecastelo.Biblioteca

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LibroDao {
    @Insert
    suspend fun insertarLibro(libro: Libro)

    @Query("SELECT * FROM libros")
    suspend fun obtenerTodosLosLibros(): List<Libro>
}
