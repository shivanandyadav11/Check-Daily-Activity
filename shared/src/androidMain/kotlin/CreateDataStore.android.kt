import Context._context
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

/**
 * Gets the singleton DataStore instance, creating it if necessary.
 */
actual fun createDataStoreSource(): DataStore<Preferences> {
    val context: Context? = _context

   return createDataStore(
        producePath = { context?.filesDir?.resolve(dataStoreFileName)?.absolutePath ?: ""}
    )
}
