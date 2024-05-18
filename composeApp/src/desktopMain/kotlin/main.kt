import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.LandingScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Check Daily Activity",
    ) {
        LandingScreen(phone = true)
    }
}