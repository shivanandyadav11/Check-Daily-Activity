package ui.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.SignUpDestination
import ui.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    phone: Boolean = true,
) {
    val navigator: Navigator = LocalNavigator.currentOrThrow
    val viewModel: AuthViewModel = viewModel<AuthViewModel> {
        AuthViewModel("Yadav")
    }
    LoginContent(
        phone = phone,
        onLogInButtonClick = { email, password ->
        },
        onSignUpTextClick = {
            navigator.push(SignUpDestination(phone = phone))
        },
        viewModel.userName.value
    )
}