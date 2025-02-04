package com.ciclomontecastelo.Biblioteca

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Libro::class], version = 1)
abstract class BibliotecaDatabase : RoomDatabase() {
    abstract fun libroDao(): LibroDao

    companion object {
        @Volatile
        private var INSTANCE: BibliotecaDatabase? = null

        fun getDatabase(context: Context): BibliotecaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BibliotecaDatabase::class.java,
                    "biblioteca_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
