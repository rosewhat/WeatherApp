package com.example.weatherapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.domain.WeatherItem
import com.example.weatherapp.presentation.bar.AppBar
import com.example.weatherapp.presentation.bar.BottomBar
import com.example.weatherapp.presentation.viewModel.MainViewModel


@Composable
fun Settings() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = "Search",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun Notifications() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.notification),
            contentDescription = "Search",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun Location() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "Search",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun WeatherHomeScreen(navController: NavController, viewModel: MainViewModel) {
    val weatherItems by viewModel.weatherItems.collectAsState()

    Scaffold(
        topBar = {
            AppBar(title = "Moscow", navController = navController)
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(weatherItems) { weatherItem ->
                WeatherCard(weatherItem = weatherItem)
            }
        }
    }
}



@Composable
fun WeatherCard(weatherItem: WeatherItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "Location",
                    tint = Color.Black,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Air Quality", fontWeight = FontWeight.Bold)
            }

            WeatherInfoRow(
                painterResource(
                    id = R.drawable.screen_1
                ), text = "Real Feel", value = weatherItem.realFeel
            )
            WeatherInfoRow(
                painterResource(id = R.drawable.screen_2), text = "So2", value = weatherItem.so2
            )
            WeatherInfoRow(
                painterResource(id = R.drawable.screen_3),
                text = "Change of Rain",
                value = weatherItem.changeOfRain
            )
            WeatherInfoRow(
                painterResource(id = R.drawable.location),
                text = "Wind",
                value = weatherItem.uvIndex
            )
        }
    }
}

@Composable
fun WeatherInfoRow(icon: Painter, text: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = icon,
                contentDescription = text,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = text, fontWeight = FontWeight.Bold)
        }
        Text(text = value)
    }
}


@Composable
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





