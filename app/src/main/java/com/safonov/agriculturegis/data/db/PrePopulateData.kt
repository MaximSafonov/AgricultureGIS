package com.safonov.agriculturegis.data.db

import com.safonov.agriculturegis.data.models.FieldData
import com.safonov.agriculturegis.data.models.PointData
import com.yandex.mapkit.geometry.Point

object PrePopulateData {

    val azovField: FieldData = FieldData(
        fieldId = 1,
        name = "Азовский район-1",
        address = "Круглянское сельское поселение, Азовский район, Ростовская область",
    )

    val zernogradField: FieldData = FieldData(
        fieldId = 2,
        name = "Зерноградский район-1",
        address = "Зерноградский район, Ростовская область",
    )

    val dubovskyField: FieldData = FieldData(
        fieldId = 3,
        name = "Дубовский район-1",
        address = "Дубовский район, Ростовская область",
    )

    val fieldList = listOf(azovField, zernogradField, dubovskyField)

    val azovFieldPoints = listOf(
        PointData.toEntity(
            PointData(
                fieldId = 1,
                latitude = 47.006073,
                longitude = 39.115005,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 1,
                latitude = 47.000397,
                longitude = 39.234938,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 1,
                latitude = 46.924486,
                longitude = 39.238710,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 1,
                latitude = 46.926036,
                longitude = 39.111988,
            )
        ),
    )

    val zernogradFieldPoints = listOf(
        PointData.toEntity(
            PointData(
                fieldId = 2,
                latitude = 46.892098,
                longitude = 40.548898,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 2,
                latitude = 46.892157,
                longitude = 40.561083,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 2,
                latitude = 46.862425,
                longitude = 40.561060,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 1,
                latitude = 46.862675,
                longitude = 40.549181,
            )
        ),
    )

    val dubovskyFieldPoints = listOf(
        PointData.toEntity(
            PointData(
                fieldId = 3,
                latitude = 47.604542,
                longitude = 42.654731,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 3,
                latitude = 47.604542,
                longitude = 42.680580,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 3,
                latitude = 47.592272,
                longitude = 42.680734,
            )
        ),
        PointData.toEntity(
            PointData(
                fieldId = 3,
                latitude = 47.592794,
                longitude = 42.654474,
            )
        ),
    )

    val azovMapPoints = azovFieldPoints.map {
        Point(it.latitude, it.longitude)
    }

    val zernogradMapPoints = zernogradFieldPoints.map {
        Point(it.latitude, it.longitude)
    }

    val dubovskyMapPoints = dubovskyFieldPoints.map {
        Point(it.latitude, it.longitude)
    }

    fun getProperFieldPoints(fieldId: Int): List<Point> =
        when (fieldId) {
            azovField.fieldId -> azovMapPoints
            zernogradField.fieldId -> zernogradMapPoints
            dubovskyField.fieldId -> dubovskyMapPoints
            else -> azovMapPoints
        }

}