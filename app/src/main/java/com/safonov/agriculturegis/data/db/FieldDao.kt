package com.safonov.agriculturegis.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FieldDao {
//    @Query("SELECT * FROM card_point_table WHERE agriculture_field_id = :fieldId")
//    fun getFieldPoints(fieldId: Int): List<PointDataEntity>

//    @Query("SELECT * FROM agriculture_field_table ORDER BY agriculture_field_id ASC")
//    fun getFieldList(): Flow<List<FieldDataEntity>>
//
//    @Query("SELECT * FROM agriculture_field_table WHERE agriculture_field_id = :fieldId")
//    fun getField(fieldId: Int): FieldDataEntity

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertPoints(fieldPoints: List<PointDataEntity>)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertField(fieldData: FieldDataEntity)

}