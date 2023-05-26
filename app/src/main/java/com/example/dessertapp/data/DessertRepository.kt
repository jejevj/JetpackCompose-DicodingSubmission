package com.example.dessertapp.data

import com.example.dessertapp.model.DessertData
import com.example.dessertapp.model.DessertList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DessertRepository {

    private val dessert = mutableListOf<DessertList>()

    init {
        if (dessert.isEmpty()) {
            DessertData.desserts.forEach {
                dessert.add(DessertList(it, 0))
            }
        }
    }

    fun getAllData(): Flow<List<DessertList>> {
        return flowOf(dessert)
    }

    fun getById(id: Long): DessertList {
        return dessert.first {
            it.dessert.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: DessertRepository? = null

        fun getInstance(): DessertRepository =
            instance ?: synchronized(this) {
                DessertRepository().apply {
                    instance = this
                }
            }
    }
}