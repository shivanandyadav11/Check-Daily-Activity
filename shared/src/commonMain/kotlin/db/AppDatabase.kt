package db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import db.convertor.Converters
import db.dao.TaskDao
import db.dao.UserDao
import db.entity.NewTask
import db.entity.UserEntity

@Database(entities = [UserEntity::class, NewTask::class], version = 4)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(), DBToClearAllTables {
    abstract fun getDao(): UserDao
    abstract fun getTaskDao(): TaskDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

// Class 'AppDatabase_Impl' is not abstract and does not implement abstract base class member 'clearAllTables'.
interface DBToClearAllTables {
    fun clearAllTables() {}
}