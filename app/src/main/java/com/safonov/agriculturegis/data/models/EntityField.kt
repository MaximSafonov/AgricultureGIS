package com.safonov.agriculturegis.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EntityField(
    @PrimaryKey val uid: Int,
    val longitude: Double,
    val latitude: Double,
    val address: String,
    val name: String,
)
