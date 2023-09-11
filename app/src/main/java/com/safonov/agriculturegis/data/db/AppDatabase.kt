package com.safonov.agriculturegis.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.safonov.agriculturegis.data.models.EntityField

@Database(entities = [EntityField::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fieldDao(): FieldDao
}