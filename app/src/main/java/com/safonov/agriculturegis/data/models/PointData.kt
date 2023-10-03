package com.safonov.agriculturegis.data.models

import com.safonov.agriculturegis.data.db.entity.PointDataEntity
import kotlin.random.Random

data class PointData(
    val fieldId: Int,
    val latitude: Double,
    val longitude: Double,
) {
    companion object {
        fun toEntity(data: PointData): PointDataEntity =
            PointDataEntity(
                uid = Random.nextInt(),
                fieldId = data.fieldId,
                latitude = data.latitude,
                longitude = data.longitude
            )
    }
}