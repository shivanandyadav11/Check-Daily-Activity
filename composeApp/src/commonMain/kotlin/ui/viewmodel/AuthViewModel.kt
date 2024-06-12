package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import model.remote.AuthToken
import model.remote.data.AuthRequest
import model.remote.repo.AuthRepository

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _userName: MutableStateFlow<String> = MutableStateFlow("")
    val userEmail: StateFlow<String> get() = _userName

    private val _authState: MutableStateFlow<AuthState> = MutableStateFlow(AuthState.NoState)
    val authState: StateFlow<AuthState> get() = _authState

    fun signIn(name: String?, email: String?, password: String?) =
        viewModelScope.launch(Dispatchers.Default) {
            _authState.emit(AuthState.Loading)
            delay(1000)
            val authRequest = AuthRequest(
                name = name.orEmpty(),
                email = email.orEmpty(),
                password = password.orEmpty()
            )
            kotlin.runCatching {
                val result = repository.signIn(authRequest).bodyAsText()
                 Json.decodeFromString(result) as AuthToken
            }.onSuccess {
                _authState.emit(AuthState.Success(it))
            }.onFailure {
                _authState.emit(AuthState.Failure)
            }.getOrElse {
                _authState.emit(AuthState.Failure)
            }
        }

    internal fun setUserEmail(email: String) {
        _userName.value = email
    }

    companion object {
        const val ERROR_MSG = "Something went wrong, please try again"
    }
}

sealed class AuthState {
    data class Success(val authCode: AuthToken): AuthState()
    data object Failure: AuthState()
    data object Loading: AuthState()
    data object NoState: AuthState()
}