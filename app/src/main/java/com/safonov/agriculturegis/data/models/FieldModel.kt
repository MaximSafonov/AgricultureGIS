package com.safonov.agriculturegis.data.models

import com.google.gson.annotations.SerializedName
import com.yandex.mapkit.geometry.Point

data class FieldModel(
    val query: String,
    val found: Int,
    val list: List<Field>,
    val points: List<Point>
) {
    class Field(
        @SerializedName("obj_type")val objectType: String,
        @SerializedName("cad_num")val cadNumber: String,
        @SerializedName("address")val fieldAddress: String,
        @SerializedName("area")val fieldArea: String,
        @SerializedName("cad_cost")val fieldCadCost: String,
        @SerializedName("status")val fieldStatus: String,
    )

    companion object {
//        fun mock(query: String): FieldModel =
//            FieldModel(
//                query = query,
//                found = 1,
//                list = listOf(
//                    Field(
//                        objectType = "Поле",
//                        cadNumber = query,
//                        fieldAddress = "Какой то адрес",
//                        fieldArea = "67,2 км2",
//                        fieldCadCost = "100 руб",
//                        fieldStatus = "Сельскохозяйственное поле"
//                    )
//                )
//            )
    }
}