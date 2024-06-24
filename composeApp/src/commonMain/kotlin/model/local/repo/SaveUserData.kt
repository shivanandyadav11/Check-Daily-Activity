package model.local.repo

import kotlinx.coroutines.flow.Flow

interface SaveUserData {
    suspend fun saveUserDate(string: String)
    suspend fun getUserData(): Flow<String>
}