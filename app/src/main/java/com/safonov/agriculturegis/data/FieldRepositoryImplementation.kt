package com.safonov.agriculturegis.data

import com.safonov.agriculturegis.api.EgrnApi
import com.safonov.agriculturegis.data.models.FieldModel

class FieldRepositoryImplementation: FieldRepository {
    private val api = EgrnApi.create()

    override suspend fun searchField(cadNumber: String): FieldModel? {
        return api.searchObject(cadNum = cadNumber)
    }
}