package com.testing.openweatherapp.api

import com.testing.openweatherapp.model.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API interface for accessing weather forecast data from OpenWeatherMap.
 */
interface WeatherApi {

    /**
     * Fetches the 5-day weather forecast (3-hour intervals) for the given city.
     *
     *
     * @param city The name of the city (e.g., "New York").
     * @param apiKey The API key for authenticating with OpenWeatherMap.
     * @param units The unit system to use (e.g., "imperial", "metric", or "standard"). Defaults to "imperial".
     * @return [ForecastResponse] containing the forecast data.
     */
    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "imperial"
    ): ForecastResponse
}