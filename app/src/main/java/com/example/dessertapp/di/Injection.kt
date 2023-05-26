package com.example.dessertapp.di

import com.example.dessertapp.data.DessertRepository

object Injection {
    fun provideRepository(): DessertRepository {
        return DessertRepository.getInstance()
    }
}