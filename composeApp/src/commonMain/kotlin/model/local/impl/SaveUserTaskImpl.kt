package model.local.impl

import db.AppDatabase
import db.NewTask
import db.TaskDao
import db.UserDao
import model.local.repo.SaveUserData
import model.local.repo.SaveUserTask

class SaveUserTaskImpl( private val database: AppDatabase): SaveUserTask {

    private val dao: TaskDao by lazy {
        database.getTaskDao()
    }

    override suspend fun saveUserTask(userTask: NewTask) {
        dao.insert(userTask)
    }
}