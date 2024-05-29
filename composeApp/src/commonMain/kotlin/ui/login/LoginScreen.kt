package ui.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.compose.koinInject
import ui.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    phone: Boolean = true,
    onLogInButtonClick: (String, String) -> Unit,
    onSignUpTextClick: () -> Unit,
) {
    val viewModel: AuthViewModel = koinInject<AuthViewModel>()
    LoginContent(
        phone = phone,
        onLogInButtonClick = { email, password ->
            onLogInButtonClick(email, password)
        },
        onSignUpTextClick = onSignUpTextClick,
        userName = viewModel.userName.value
    )
}