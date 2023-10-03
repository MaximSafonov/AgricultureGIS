package com.safonov.agriculturegis.data

import com.safonov.agriculturegis.data.db.entity.FieldDataEntity
import com.safonov.agriculturegis.data.db.entity.PointDataEntity
import com.safonov.agriculturegis.data.models.FieldModel
import com.yandex.mapkit.geometry.Point
import kotlinx.coroutines.flow.Flow

interface FieldRepository {
    suspend fun searchField(cadNumber: String): FieldModel?

//    fun getField(fieldId: Int): List<PointDataEntity>
//
//    val allFields: Flow<List<FieldDataEntity>>
}