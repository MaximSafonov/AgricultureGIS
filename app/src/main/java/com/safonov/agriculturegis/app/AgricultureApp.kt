package com.safonov.agriculturegis.app

import android.app.Application
import com.safonov.agriculturegis.app.Constants.YANDEX_MAPKIT_KEY
import com.yandex.mapkit.MapKitFactory

class AgricultureApp: Application() {

    override fun onCreate() {
        MapKitFactory.setApiKey(YANDEX_MAPKIT_KEY)
        super.onCreate()
    }
}