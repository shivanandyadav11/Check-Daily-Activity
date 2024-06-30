package model.local.impl

import db.AppDatabase
import db.entity.NewTask
import db.dao.TaskDao
import kotlinx.coroutines.flow.Flow
import model.local.repo.SaveUserTask

class SaveUserTaskImpl( private val database: AppDatabase): SaveUserTask {

    private val dao: TaskDao by lazy {
        database.getTaskDao()
    }

    override suspend fun saveUserTask(userTask: NewTask) {
        dao.insert(userTask)
    }

    override suspend fun getUserAllTask(): Flow<List<NewTask>?> {
        return dao.getUserAllTask()
    }
}