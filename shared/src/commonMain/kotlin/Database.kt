import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

fun getRoomDatabase(): AppDatabase {
    return getDatabaseBuilder()
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}