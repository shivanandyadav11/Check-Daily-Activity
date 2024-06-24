package ui.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject
import ui.viewmodel.AuthViewModel
import ui.viewmodel.UserState

@Composable
fun LandingScreen(
    phone: Boolean = true,
    onLogInClick: () -> Unit,
    onSignUpClick: () -> Unit,
    userIsAlreadyAuthenticated: () -> Unit,
) {
    val viewModel: AuthViewModel = koinInject<AuthViewModel>()
    viewModel.userToken()
    val token = viewModel.userToken.collectAsState()

    when(token.value) {
         is UserState.LogOut -> {
             LandingContent(
                 phone = phone,
                 onLogInClick = onLogInClick,
                 onSignUpClick = onSignUpClick,
             )
         }
        is UserState.LoggedIn -> userIsAlreadyAuthenticated()
        is UserState.NoState -> Unit
    }
}
