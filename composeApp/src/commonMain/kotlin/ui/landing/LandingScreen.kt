package ui.landing

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import navigation.LoginDestination
import navigation.SignUpDestination

@Composable
fun LandingScreen(
    phone: Boolean = true,
) {
    val navigator: Navigator = LocalNavigator.currentOrThrow
    LandingContent(
        phone = phone,
        onLogInClick = {
            navigator.push(LoginDestination(phone = phone))
        },
        onSignUpClick = {
            navigator.push(SignUpDestination(phone = phone))
        }
    )
}
