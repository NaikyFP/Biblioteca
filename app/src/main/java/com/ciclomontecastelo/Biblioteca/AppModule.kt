package com.ciclomontecastelo.Biblioteca

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext app: Application): BibliotecaDatabase {
        return Room.databaseBuilder(app, BibliotecaDatabase::class.java, "biblioteca_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideLibroDao(database: BibliotecaDatabase): LibroDao {
        return database.libroDao()
    }

    @Provides
    fun provideBibliotecaRepository(libroDao: LibroDao): BibliotecaRepository {
        return BibliotecaRepository(libroDao)
    }
}
