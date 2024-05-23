package ui.login

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.SignUpDestination

@Composable
fun LoginScreen(
    phone: Boolean = true,
) {
    val navigator: Navigator = LocalNavigator.currentOrThrow
    LoginContent(
        phone = phone,
        onLogInButtonClick = { email, password ->
        },
        onSignUpTextClick = {
            navigator.push(SignUpDestination(phone = phone))
        }
    )
}