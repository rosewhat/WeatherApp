package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.WeatherItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _weatherItems = MutableStateFlow<List<WeatherItem>>(emptyList())
    val weatherItems: StateFlow<List<WeatherItem>> get() = _weatherItems
    init {
        _weatherItems.value = generateDummyWeatherItems()
    }

}

fun generateDummyWeatherItems(): List<WeatherItem> {
    return List(5) {
        WeatherItem(
            airQuality = "Good",
            realFeel = "25°C",
            so2 = "Low",
            changeOfRain = "10%",
            uvIndex = "Moderate"
        )
    }
}