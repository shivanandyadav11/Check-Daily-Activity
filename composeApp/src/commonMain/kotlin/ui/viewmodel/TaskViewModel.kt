package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import db.NewTask
import model.local.repo.SaveUserTask
import model.remote.repo.AuthRepository

class TaskViewModel(
    private val saveUserTask: SaveUserTask,
) : ViewModel() {

    fun saveNewTask(newTask: NewTask) = viewModelScope.launch(Dispatchers.IO) {
        saveUserTask.saveUserTask(newTask)
    }
}