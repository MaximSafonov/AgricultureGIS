package com.safonov.agriculturegis.data

import com.safonov.agriculturegis.api.EgrnApi
import com.safonov.agriculturegis.data.db.FieldDao
import com.safonov.agriculturegis.data.db.entity.FieldDataEntity
import com.safonov.agriculturegis.data.db.entity.PointDataEntity
import com.safonov.agriculturegis.data.models.FieldModel
import kotlinx.coroutines.flow.Flow

class FieldRepositoryImplementation(private val fieldDao: FieldDao): FieldRepository {
    private val api = EgrnApi.create()


    override suspend fun searchField(cadNumber: String): FieldModel? {
        return api.searchObject(cadNum = cadNumber)
    }

//    override val allFields: Flow<List<FieldDataEntity>> {
//        fieldDao.getFieldList()
//    }

//    override fun getField(fieldId: Int): List<PointDataEntity> =
//        fieldDao.getFieldPoints(fieldId)

}