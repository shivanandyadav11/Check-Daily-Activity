package ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import repo.MyRepository

class AuthViewModel(val repository: MyRepository) : ViewModel() {

    private val _userName: MutableStateFlow<String> = MutableStateFlow("")
    val userName: StateFlow<String> get() = _userName

    init {
        setUserName(repository.getData())
    }

    internal fun setUserName(name: String) {
        _userName.value = name
    }
}