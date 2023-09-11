package com.safonov.agriculturegis.data.models

import com.yandex.mapkit.geometry.Point

data class Sensor(
    val id: Int,
    val title: String,
    val point: Point,
    val area: Int,
)
