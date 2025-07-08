package com.testing.openweatherapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testing.openweatherapp.model.ForecastItem
import com.testing.openweatherapp.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel responsible for managing weather forecast data and UI state.
 *
 * @param repository The repository providing weather data.
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    /** Holds the city name entered by the user */
    var cityName by mutableStateOf("")
        private set

    /** Holds the list of forecast items */
    var forecastList by mutableStateOf<List<ForecastItem>>(emptyList())
        private set

    /** Holds the currently selected forecast item */
    var selectedForecast by mutableStateOf<ForecastItem?>(null)
        private set

    /** Holds error message if any during data fetching */
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    /**
     * Updates the city name state from UI input.
     *
     * @param newCity The new city name entered.
     */
    fun onCityNameChanged(newCity: String) {
        cityName = newCity
    }

    /**
     * Fetches forecast data for the specified city.
     * Ignores empty or blank city names.
     *
     * @param city The city to fetch forecast for.
     */
    fun fetchForecast(city: String) {
        if (city.isBlank()) return

        viewModelScope.launch {
            try {
                val response = repository.getForecast(city)
                forecastList = response.list
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = e.localizedMessage ?: "Failed to fetch forecast"
            }
        }
    }

    /**
     * Sets the currently selected forecast item.
     *
     * @param item The forecast item selected by the user.
     */
    fun selectForecast(item: ForecastItem) {
        selectedForecast = item
    }
}
