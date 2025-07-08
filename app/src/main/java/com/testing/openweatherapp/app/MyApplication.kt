package com.testing.openweatherapp.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Custom Application class required by Hilt for dependency injection.
 *
 * Annotating this class with @HiltAndroidApp triggers Hilt's code generation,
 * including a base class for your application that serves as the application-level
 * dependency container.
 */
@HiltAndroidApp
class MyApplication : Application(){
}