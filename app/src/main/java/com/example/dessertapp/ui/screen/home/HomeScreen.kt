package com.example.dessertapp.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.dessertapp.di.Injection
import com.example.dessertapp.model.DessertList
import com.example.dessertapp.ui.common.UiState
import com.example.dessertapp.ui.components.DessertsCatalog
import com.example.dessertapp.ui.screen.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {
        when(it) {
            is UiState.Loading -> {
                viewModel.getAllData()
            }
            is UiState.Success -> {
                HomeListData(dessertList = it.data, navigateToDetail = navigateToDetail)
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeListData(
    dessertList: List<DessertList>,
    navigateToDetail: (Long) -> Unit
) {
    Box(modifier = Modifier) {
        LazyColumn {
            items(dessertList) {
                DessertsCatalog(name = it.dessert.dessert_name, highlights = it.dessert.dessert_highlights, image = it.dessert.dessert_picture, modifier = Modifier.clickable {
                    navigateToDetail(it.dessert.id)
                })
            }
        }
    }

}