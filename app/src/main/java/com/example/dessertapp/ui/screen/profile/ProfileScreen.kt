package com.example.dessertapp.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dessertapp.ui.theme.SubmissionApplicationTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onBackClick:() -> Unit
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
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .padding(16.dp)
                    .clip(CircleShape),
                painter = painterResource(com.example.dessertapp.R.drawable.profile_pic),
                contentDescription = "profile"
            )
            Text(
                text = "J Angga Wijaya",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "wijaya.angga.j@gmail.com",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    SubmissionApplicationTheme {
        ProfileScreen(onBackClick = {})
    }
}