import Context._context
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import db.AppDatabase

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val context: Context = _context!!
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}