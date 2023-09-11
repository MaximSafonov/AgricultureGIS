package com.safonov.agriculturegis.data.models

enum class Season(val temperature: IntRange) {
    Summer(temperature = 10..30),
    Spring(temperature = -5..10),
    Winter(temperature = -20..10),
    Autumn(temperature = -10..20),
}