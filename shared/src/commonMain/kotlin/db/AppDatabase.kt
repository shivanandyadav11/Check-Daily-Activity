package db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class, NewTask::class], version = 2)
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