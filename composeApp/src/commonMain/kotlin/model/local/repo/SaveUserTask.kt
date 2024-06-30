package model.local.repo

import db.entity.NewTask
import kotlinx.coroutines.flow.Flow

interface SaveUserTask {
    suspend fun saveUserTask(userTask: NewTask)
    suspend fun getUserAllTask(): Flow<List<NewTask>?>
}