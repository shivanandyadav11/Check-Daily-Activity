package model.local.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.local.repo.SaveUserData

class SaveUserDataImpl(private val dataStore: DataStore<Preferences>): SaveUserData {

    private val AUTH_TOKEN_KEY = stringPreferencesKey("example_key")

    override suspend fun saveUserDate(string: String) {
        dataStore.edit { preferences ->
            preferences[AUTH_TOKEN_KEY] = string  }
    }

    override suspend fun getUserData(): Flow<String> =
        dataStore.data.map { preferences -> preferences[AUTH_TOKEN_KEY] ?: "" }
}