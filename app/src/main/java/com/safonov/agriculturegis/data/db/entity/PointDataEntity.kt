package com.safonov.agriculturegis.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Fts4
import androidx.room.PrimaryKey

//@Fts4
//@Entity(
//    tableName = "card_point_table",
//    foreignKeys = [
//        ForeignKey(
//            entity = FieldDataEntity::class,
//            parentColumns = ["agriculture_field_id"],
//            childColumns = ["agriculture_field_id"]
//        )]
//)
data class PointDataEntity(
    @PrimaryKey @ColumnInfo(name = "rowid") val uid: Int,
    @ColumnInfo(name = "agriculture_field_id") val fieldId: Int,
    @ColumnInfo(name = "card_point_latitude") val latitude: Double,
    @ColumnInfo(name = "card_point_longitude") val longitude: Double,


    )