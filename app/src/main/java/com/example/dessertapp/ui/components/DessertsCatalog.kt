package com.example.dessertapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dessertapp.ui.theme.SubmissionApplicationTheme

@Composable
fun DessertsCatalog(
    name: String,
    highlights: String,
    image: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(model = image, contentDescription = "laptop_image", contentScale = ContentScale.Crop,
        modifier = Modifier.height(120.dp).width(120.dp).padding(start = 8.dp))
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp, end = 8.dp)
            )
            Text(
                text = highlights,
                fontWeight = FontWeight.Normal,
                maxLines = 3,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp, end = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DessertCatalogPreview() {
    SubmissionApplicationTheme {
        DessertsCatalog(name = "LAPTOP NAME", highlights = "laptop highlights", image = "")
    }
}