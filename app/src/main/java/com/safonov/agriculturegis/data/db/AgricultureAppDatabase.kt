package com.safonov.agriculturegis.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//@Database(entities = [FieldDataEntity::class], [PointDataEntity::class], version = 1, exportSchema = false)
abstract class AgricultureAppDatabase : RoomDatabase() {
    abstract fun fieldDao(): FieldDao

    private class AgricultureDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
//                    val fieldDao = database.fieldDao()
//                    fieldDao.insertPoints(PrePopulateData.azovFieldPoints)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AgricultureAppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope,
        ): AgricultureAppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AgricultureAppDatabase::class.java,
                    "agriculture_database"
                )
                    .addCallback(AgricultureDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}