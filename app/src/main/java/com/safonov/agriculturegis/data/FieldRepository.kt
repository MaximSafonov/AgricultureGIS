package com.safonov.agriculturegis.data

import com.safonov.agriculturegis.data.models.FieldModel

interface FieldRepository {
    suspend fun searchField(cadNumber: String): FieldModel?
}