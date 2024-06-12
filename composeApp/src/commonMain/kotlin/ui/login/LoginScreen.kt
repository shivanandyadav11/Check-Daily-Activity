package ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import ui.viewmodel.AuthState
import ui.viewmodel.AuthViewModel
import ui.viewmodel.AuthViewModel.Companion.ERROR_MSG

@Composable
fun LoginScreen(
    phone: Boolean = true,
    onSuccessFullLogin: () -> Unit,
    onSignUpTextClick: () -> Unit,
) {
    val viewModel: AuthViewModel = koinInject<AuthViewModel>()
    val authState = viewModel.authState.collectAsState()
    val userEmail = viewModel.userEmail.collectAsState()

    when(authState.value) {
        is AuthState.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    CircularProgressIndicator(
                        modifier = Modifier.size(64.dp),
                        color = Color(0xFF5B67CA),
                        strokeWidth = 4.dp
                    )
                    Text("Loading")
                }
            }
        }
        is AuthState.Failure -> {
            LoginContent(
                phone = phone,
                onLogInButtonClick = { email, password ->
                    viewModel.signIn(name = "", email = email, password = password)
                    viewModel.setUserEmail(email = email)
                },
                onSignUpTextClick = onSignUpTextClick,
                userEmail = userEmail,
                error = ERROR_MSG
            )
        }
        is AuthState.Success -> {
            onSuccessFullLogin()
        }
        is AuthState.NoState -> {
            LoginContent(
                phone = phone,
                onLogInButtonClick = { email, password ->
                    viewModel.signIn(name = "", email = email, password = password)
                    viewModel.setUserEmail(email = email)
                },
                onSignUpTextClick = onSignUpTextClick,
                userEmail = userEmail,
            )
        }
    }

}