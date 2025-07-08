package com.testing.openweatherapp.navigation

/**
 * Defines all the navigation routes used in the application.
 * Each screen is represented as an object extending the sealed class [Screen].
 */
sealed class Screen(val route: String) {
    /** Screen for entering city name and initiating search */
    object Lookup : Screen("lookup")

    /** Screen showing list of weather forecasts */
    object ForecastList : Screen("forecast_list")

    /** Screen showing detailed forecast information */
    object ForecastDetail : Screen("forecast_detail")
}