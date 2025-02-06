package com.ciclomontecastelo.Biblioteca

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @ViewModelScoped
    @Provides
    fun provideBibliotecaViewModel(repository: BibliotecaRepository): BibliotecaViewModel {
        return BibliotecaViewModel(repository)
    }
}
