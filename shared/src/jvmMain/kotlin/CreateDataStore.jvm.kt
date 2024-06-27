import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

/**
 * Gets the singleton DataStore instance, creating it if necessary.
 */
actual fun createDataStoreSource(): DataStore<Preferences>  = createDataStore(
    producePath = { dataStoreFileName }
)