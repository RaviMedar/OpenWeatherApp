package com.testing.openweatherapp.uiscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.testing.openweatherapp.model.ForecastItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastListScreen(
    cityName: String,
    forecastList: List<ForecastItem>,
    onItemClick: (ForecastItem) -> Unit,
    onBackClick: () -> Unit
) {
    Column {
        TopAppBar(
            title = { Text(cityName) },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },modifier = Modifier.statusBarsPadding(),
            backgroundColor = Color(0xFF6750A4), // purple
            contentColor = Color.White
        )

        LazyColumn {
            items(forecastList) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item) }
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item.weather.firstOrNull()?.main ?: "N/A")
                    Text(text = "Temp: ${item.main.temp.toInt()}")
                }
                Divider()
            }
        }
    }
}

