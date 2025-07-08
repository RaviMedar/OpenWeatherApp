package com.testing.openweatherapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.testing.openweatherapp.uiscreen.ForecastDetailScreen
import com.testing.openweatherapp.uiscreen.ForecastListScreen
import com.testing.openweatherapp.uiscreen.LookupScreen
import com.testing.openweatherapp.viewmodel.WeatherViewModel

/**
 * Sets up the application's navigation graph using Jetpack Compose Navigation.
 *
 * @param navController The NavHostController used for navigating between screens.
 * @param viewModel The shared WeatherViewModel used to manage UI state and data.
 */
@Composable
fun AppNavGraph(navController: NavHostController, viewModel: WeatherViewModel) {
    val cityName = viewModel.cityName
    val forecastList = viewModel.forecastList
    NavHost(navController, startDestination = Screen.Lookup.route) {
        composable(Screen.Lookup.route) {
            LookupScreen(
                cityName = cityName,
                onCityNameChange = viewModel::onCityNameChanged,
                onSearchClick = {
                    viewModel.fetchForecast(cityName)
                    navController.navigate(Screen.ForecastList.route)
                }
            )
        }
        composable(Screen.ForecastList.route) {
            ForecastListScreen(
                cityName = cityName,
                forecastList = forecastList,
                onItemClick = { item ->
                    viewModel.selectForecast(item)
                    navController.navigate(Screen.ForecastDetail.route)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.ForecastDetail.route) {
            val forecast = viewModel.selectedForecast
            if (forecast != null) {
                ForecastDetailScreen(
                    cityName = viewModel.cityName,
                    forecast = forecast,
                    onBackClick = { navController.popBackStack() }
                )
            } else {
                // Optional: fallback if no item selected
                Text("No forecast selected")
            }
        }
    }
}
