package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import model.remote.data.AuthRequest
import model.remote.repo.AuthRepository

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _userName: MutableStateFlow<String> = MutableStateFlow("")
    val userName: StateFlow<String> get() = _userName


    fun signIn(name: String?, email: String?, password: String?) =
        viewModelScope.launch(Dispatchers.Default) {
            val authRequest = AuthRequest(
                name = name.orEmpty(),
                email = email.orEmpty(),
                password = password.orEmpty()
            )
            kotlin.runCatching {
                val result = repository.signIn(authRequest)
                println(result.status)
            }
        }
}