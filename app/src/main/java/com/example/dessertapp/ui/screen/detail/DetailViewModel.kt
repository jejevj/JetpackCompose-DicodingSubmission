package com.example.dessertapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dessertapp.data.DessertRepository
import com.example.dessertapp.model.DessertList
import com.example.dessertapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: DessertRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<DessertList>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<DessertList>>
        get() = _uiState

    fun getById(phoneId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getById(phoneId))
        }
    }
}