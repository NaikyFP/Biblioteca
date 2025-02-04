package com.ciclomontecastelo.Biblioteca

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libro(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val autor: String,
    val genero: String,
    val disponible: Boolean
)
