package com.testing.openweatherapp.repo

import com.testing.openweatherapp.api.WeatherApi
import com.testing.openweatherapp.model.ForecastResponse
import javax.inject.Inject

/**
 * Repository responsible for retrieving weather forecast data from the Weather API.
 *
 * @param api The Retrofit service interface for weather API calls.
 */
class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {

    /**
     * Fetches weather forecast data for the specified city.
     *
     * @param city The name of the city.
     * @return [ForecastResponse] containing the forecast details.
     */
    suspend fun getForecast(city: String): ForecastResponse {
        return api.getForecast(
            city = city,
            apiKey = API_KEY
        )
    }

    companion object {
        // Ideally this should come from secure storage or BuildConfig
        private const val API_KEY = "65d00499677e59496ca2f318eb68c049"
    }
}
