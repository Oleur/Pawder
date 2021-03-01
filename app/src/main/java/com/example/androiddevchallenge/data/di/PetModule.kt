package com.example.androiddevchallenge.data.di

import com.example.androiddevchallenge.data.PetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PetModule {

    @Provides
    @Singleton
    fun providePetRepository() = PetRepository()
}