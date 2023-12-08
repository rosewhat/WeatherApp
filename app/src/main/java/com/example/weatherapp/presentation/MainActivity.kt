package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.presentation.navigation.GreetingScreen
import com.example.weatherapp.presentation.navigation.Notifications
import com.example.weatherapp.presentation.navigation.Search
import com.example.weatherapp.presentation.navigation.Settings
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WeatherAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ) {
                    composable("Home") {
                        GreetingScreen(navController = navController)
                    }
                    composable("Search") {
                        Search()
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



    companion object {
        const val HEAT = "Тепло"
        const val HOT = "Жарко"
        const val COLD = "Холодно"
    }
}
