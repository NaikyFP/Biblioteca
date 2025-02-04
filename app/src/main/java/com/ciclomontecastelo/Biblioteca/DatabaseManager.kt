package com.ciclomontecastelo.Biblioteca

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DatabaseManager(context: Context) {

    private val dbHelper = DatabaseHelper(context)
    private val db = dbHelper.writableDatabase

    fun insertarLibro(titulo: String, autor: String, genero: String, disponible: Boolean): Long {
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_TITULO, titulo)
            put(DatabaseHelper.COLUMN_AUTOR, autor)
            put(DatabaseHelper.COLUMN_GENERO, genero)
            put(DatabaseHelper.COLUMN_DISPONIBLE, if (disponible) 1 else 0)
        }
        return db.insert(DatabaseHelper.TABLE_LIBROS, null, values)
    }

    fun obtenerTodosLosLibros(): Cursor {
        return db.query(
            DatabaseHelper.TABLE_LIBROS,
            null, null, null, null, null, null
        )
    }

    fun actualizarLibro(id: Long, titulo: String, autor: String, genero: String, disponible: Boolean): Int {
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_TITULO, titulo)
            put(DatabaseHelper.COLUMN_AUTOR, autor)
            put(DatabaseHelper.COLUMN_GENERO, genero)
            put(DatabaseHelper.COLUMN_DISPONIBLE, if (disponible) 1 else 0)
        }
        return db.update(
            DatabaseHelper.TABLE_LIBROS,
            values,
            "${DatabaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString())
        )
    }

    fun eliminarLibro(id: Long): Int {
        return db.delete(
            DatabaseHelper.TABLE_LIBROS,
            "${DatabaseHelper.COLUMN_ID} = ?",
            arrayOf(id.toString())
        )
    }
}
