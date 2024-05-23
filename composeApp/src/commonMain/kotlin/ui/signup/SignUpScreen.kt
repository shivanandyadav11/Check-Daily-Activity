package ui.signup

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.LoginDestination

@Composable
fun SignUpScreen(
    phone: Boolean = true,
) {
    val navigator: Navigator = LocalNavigator.currentOrThrow
    SignUpContent(
        phone = phone,
        onCreateButtonClick = {
            userNamme, mail, password -> {

        }
        },
        onLoginTextClicked = {
            navigator.push(LoginDestination(phone = phone))
        }
    )
}