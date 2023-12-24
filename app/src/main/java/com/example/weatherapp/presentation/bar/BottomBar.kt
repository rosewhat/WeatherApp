package com.example.weatherapp.presentation.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavController) {
    BottomAppBar(
        modifier = Modifier.background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navController.navigate("Location") }) {
                Icon(
                    painterResource(id = R.drawable.location),
                    contentDescription = "Location", tint = Color.Black,
                    modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.weather),
                    contentDescription = "Weather", tint = Color.Black,
                    modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = { navController.navigate("Settings") }) {
                Icon(
                    painterResource(id = R.drawable.settings_1),
                    contentDescription = "Settings", tint = Color.Black,
                    modifier = Modifier.size(28.dp))
            }
        }
    }
}
