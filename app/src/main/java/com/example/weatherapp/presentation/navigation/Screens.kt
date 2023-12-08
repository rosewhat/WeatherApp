package com.example.weatherapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.data.GetTimeWeather
import com.example.weatherapp.data.GetTypeWeather
import com.example.weatherapp.presentation.AppBar
import com.example.weatherapp.presentation.BottomBar
import com.example.weatherapp.presentation.MainActivity


@Composable
fun Settings() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Настройки",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
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
        Text(
            text = "Уведомления",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Search() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Поиск",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun GreetingScreen(navController: NavController) {
    val city = "Москва"
    val currentWeather = 20
    val weatherTypeList = listOf(
        GetTypeWeather(10, "Холодно"),
        GetTypeWeather(12, "Холодно"),
        GetTypeWeather(15, "Солнечно"),
        GetTypeWeather(18, "Солнечно"),
        GetTypeWeather(21, "Солнечно"),
        GetTypeWeather(24, "Тепло"),
        GetTypeWeather(27, "Жарко"),
    )
    val weatherTimeList = listOf(
        GetTimeWeather(5, "9:00"),
        GetTimeWeather(10, "12:00"),
        GetTimeWeather(15, "15:00"),
        GetTimeWeather(20, "18:00"),
        GetTimeWeather(25, "21:00"),
        GetTimeWeather(30, "22:00"),
        GetTimeWeather(35, "23:00"),
    )

    Scaffold(
        topBar = {
            AppBar(title = "OpenWeather", navController = navController)
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = city,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 35.dp),
            )
            Text(
                text = "$currentWeather °C",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp),
            )
            Text(
                text = getCurrentWeather(currentWeather),
                modifier = Modifier.padding(top = 15.dp),
                color = Color.Gray
            )
            LazyRow {
                items(weatherTypeList) {
                    TypeWeather(it)
                }
            }
            LazyRow {
                items(weatherTimeList) {
                    TimeWeather(it)
                }
            }
        }
    }
}

@Composable
fun TypeWeather(getTypeWeather: GetTypeWeather) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
    ) {
        Text(
            text = "${getTypeWeather.temp} °C",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = getTypeWeather.typeWeather,
            fontSize = 12.sp,
        )
    }
}


@Composable
fun TimeWeather(getTypeWeather: GetTimeWeather) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 60.dp, 0.dp, 20.dp),
    ) {
        Text(
            text = "${getTypeWeather.temp}°C",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = getTypeWeather.time,
            fontSize = 12.sp
        )
    }
}


private fun getCurrentWeather(current: Int): String {
    return if (current > 40) {
        MainActivity.HOT
    } else if (current in 16..39) {
        MainActivity.HEAT
    } else {
        MainActivity.COLD
    }
}