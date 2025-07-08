package com.testing.openweatherapp.uiscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.testing.openweatherapp.model.ForecastItem

/**
 * Displays detailed weather forecast information for the selected city and forecast item.
 *
 * @param cityName The name of the city.
 * @param forecast The forecast data to display.
 * @param onBackClick Callback invoked when back button is clicked.
 */
@Composable
fun ForecastDetailScreen(
    cityName: String,
    forecast: ForecastItem,
    onBackClick: () -> Unit
) {
    Column {
        TopAppBar(
            title = { Text(cityName) },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            modifier = Modifier.statusBarsPadding(),
            backgroundColor = Color(0xFF6750A4),
            contentColor = Color.White
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .padding(32.dp),
        ) {
            Text(
                text = forecast.main.temp.toInt().toString(),
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold
            )
            Text("Feels Like: ${forecast.main.feelsLike.toInt()}")

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = forecast.weather.firstOrNull()?.main ?: "",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = forecast.weather.firstOrNull()?.description ?: "",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

