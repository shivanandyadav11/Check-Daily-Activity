package model.local.repo

import db.NewTask

interface SaveUserTask {
    suspend fun saveUserTask(userTask: NewTask)
}