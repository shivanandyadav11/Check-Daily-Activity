package navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import ui.landing.LandingScreen
import ui.login.LoginScreen
import ui.signup.SignUpScreen

data class LandingDestination(val phone: Boolean = true) : Screen {
    @Composable
    override fun Content() {
        LandingScreen(phone = phone)
    }
}

data class LoginDestination(val phone: Boolean = true) : Screen {
    @Composable
    override fun Content() {
        LoginScreen(phone = phone)
    }
}

data class SignUpDestination(val phone: Boolean = true) : Screen {
    @Composable
    override fun Content() {
        SignUpScreen(phone = phone)
    }
}

object HomeDestination : Screen {
    @Composable
    override fun Content() {
        // TODO
    }
}
