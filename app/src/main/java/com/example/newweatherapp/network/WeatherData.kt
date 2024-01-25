package com.example.newweatherapp.network

data class WeatherData(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<MainData>,
    val message: Int
)