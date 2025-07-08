package com.testing.openweatherapp.model

import com.google.gson.annotations.SerializedName

/**
 * Root response from the OpenWeatherMap forecast API.
 */
data class ForecastResponse(
    val list: List<ForecastItem>,
    val city: City
)

/**
 * Represents a forecast entry for a specific time.
 */
data class ForecastItem(
    @SerializedName("dt_txt")
    val dateTime: String,

    val main: Main,

    val weather: List<Weather>
)

/**
 * Contains temperature information for the forecast.
 */
data class Main(
    val temp: Float,

    @SerializedName("feels_like")
    val feelsLike: Float
)

/**
 * Describes weather conditions such as clear, rain, etc.
 */
data class Weather(
    val main: String,
    val description: String
)

/**
 * City information included in the forecast response.
 */
data class City(
    val name: String
)


