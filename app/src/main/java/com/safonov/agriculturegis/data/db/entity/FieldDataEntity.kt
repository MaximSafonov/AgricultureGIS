package com.safonov.agriculturegis.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

//@Fts4
//@Entity(tableName = "agriculture_field_table")
data class FieldDataEntity(
    @PrimaryKey  @ColumnInfo(name = "rowid") val id: Int,
    @ColumnInfo(name = "agriculture_field_name") val name: String,
    @ColumnInfo(name = "agriculture_field_address") val address: String,
)