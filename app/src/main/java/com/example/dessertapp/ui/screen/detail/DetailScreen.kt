package com.example.dessertapp.ui.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dessertapp.di.Injection
import com.example.dessertapp.ui.common.UiState
import com.example.dessertapp.ui.screen.ViewModelFactory
import com.example.dessertapp.ui.theme.SubmissionApplicationTheme

@Composable
fun DetailScreen(
    id: Long,
    viewModel: DetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateBack: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { 
        when(it) {
            is UiState.Loading -> {
                viewModel.getById(id)
            }
            is UiState.Success -> {
                val data = it.data
                DetailLaptop(
                    dessert_name = data.dessert.dessert_name,
                    dessert_highlights = data.dessert.dessert_highlights,
                    dessert_country = data.dessert.dessert_country,
                    dessert_picture = data.dessert.dessert_picture,
                    onBackClick = navigateBack)
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailLaptop(
    dessert_name: String,
    dessert_highlights: String,
    dessert_country: String,
    dessert_picture: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
            )
            AsyncImage(model = dessert_picture, contentDescription = "dessert_image", contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = dessert_name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = dessert_highlights,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "More Information",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Country : ${dessert_country}")
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailLaptopPreview() {
    SubmissionApplicationTheme {
        DetailLaptop(
            dessert_name = "dessert name",
            dessert_highlights = "dessert highlights",
            dessert_country = "dessert country",
            dessert_picture = "dessert picture",
            onBackClick = {}
        )
    }
}