package model.local.repo

import db.UserEntity
import kotlinx.coroutines.flow.Flow

interface SaveUserData {
    suspend fun saveUserData(string: String)
    suspend fun getUserData(): Flow<String>
    suspend fun saveUserInfo(userEntity: UserEntity)
    suspend fun getUserInfo(): Flow<UserEntity?>
}