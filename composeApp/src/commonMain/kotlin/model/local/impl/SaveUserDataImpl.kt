package model.local.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import db.AppDatabase
import db.dao.UserDao
import db.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.local.repo.SaveUserData

class SaveUserDataImpl(private val dataStore: DataStore<Preferences>, private val database: AppDatabase): SaveUserData {

    private val AUTH_TOKEN_KEY = stringPreferencesKey("example_key")

    private val dao: UserDao by lazy {
        database.getDao()
    }

    override suspend fun saveUserData(string: String) {
        dataStore.edit { preferences ->
            preferences[AUTH_TOKEN_KEY] = string  }
    }

    override suspend fun getUserData(): Flow<String> =
        dataStore.data.map { preferences -> preferences[AUTH_TOKEN_KEY] ?: "" }

    override suspend fun saveUserInfo(userEntity: UserEntity) {
        dao.insert(userEntity)
    }

    override suspend fun getUserInfo(): Flow<UserEntity?> {
        return dao.getUser()
    }
}