package com.safonov.agriculturegis.app

import android.app.Application
import com.safonov.agriculturegis.app.Constants.YANDEX_MAPKIT_KEY
import com.safonov.agriculturegis.data.FieldRepository
import com.safonov.agriculturegis.data.FieldRepositoryImplementation
import com.safonov.agriculturegis.data.db.AgricultureAppDatabase
import com.yandex.mapkit.MapKitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class AgricultureApp: Application() {

    val applicationScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

//    lateinit var database: AgricultureAppDatabase
//    lateinit var repository: FieldRepository
//
    val database by lazy { AgricultureAppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { FieldRepositoryImplementation(database.fieldDao()) }


    override fun onCreate() {
        MapKitFactory.setApiKey(YANDEX_MAPKIT_KEY)
        super.onCreate()
//
//        database = AgricultureAppDatabase.getDatabase(this, applicationScope)
//        repository = FieldRepositoryImplementation(database.fieldDao())
    }
}