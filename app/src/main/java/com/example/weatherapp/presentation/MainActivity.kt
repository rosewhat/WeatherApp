package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.presentation.navigation.WeatherHomeScreen
import com.example.weatherapp.presentation.navigation.Notifications
import com.example.weatherapp.presentation.navigation.Location
import com.example.weatherapp.presentation.navigation.Settings
import com.example.weatherapp.presentation.viewModel.MainViewModel
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: MainViewModel = viewModel()
            WeatherAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ) {
                    composable("Home") {
                        WeatherHomeScreen(navController = navController, viewModel = viewModel)
                    }
                    composable("Location") {
                        Location()
                    }
                    composable("Settings") {
                        Settings()
                    }
                    composable("Notifications") {
                        Notifications()
                    }
                }
            }
        }
    }
}


