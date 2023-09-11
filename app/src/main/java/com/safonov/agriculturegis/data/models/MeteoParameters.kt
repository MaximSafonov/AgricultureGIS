package com.safonov.agriculturegis.data.models

data class MeteoParameters(
    val atmPressure: Int, //P
    val maxAirTemperature: Double, // Tmax curr month
    val minAirTemperature: Double, // Tmin curr month
    val middleAirTemperatureCurrMonth: Double, //T
    val middleAirTemperaturePrevMonth: Double, //T(t-1)
    val windSpeed: Double, // U
    val pureRadiation: Double, //Rn
) 