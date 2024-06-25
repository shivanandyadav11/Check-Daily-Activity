import androidx.room.Room
import androidx.room.RoomDatabase
import db.AppDatabase
import java.io.File

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    )
}