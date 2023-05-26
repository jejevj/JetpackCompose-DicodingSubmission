package com.example.dessertapp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dessertapp.data.DessertRepository
import com.example.dessertapp.model.DessertList
import com.example.dessertapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: DessertRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<DessertList>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<DessertList>>>
        get() = _uiState

    fun getAllData() {
        viewModelScope.launch {
            repository.getAllData()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }

}