package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import db.entity.NewTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import model.local.repo.SaveUserTask

class TaskViewModel(
    private val saveUserTask: SaveUserTask,
) : ViewModel() {

    private val _todayTask = MutableStateFlow<List<NewTask>?>(null)
    val todayTask: StateFlow<List<NewTask>?> get() = _todayTask

    fun saveNewTask(newTask: NewTask) = viewModelScope.launch(Dispatchers.IO) {
        saveUserTask.saveUserTask(newTask)
    }

    fun getUserDate() = viewModelScope.launch(Dispatchers.IO) {
        saveUserTask.getUserAllTask().collectLatest { listOfNewTasks ->
            _todayTask.emit(listOfNewTasks)
        }
    }
}