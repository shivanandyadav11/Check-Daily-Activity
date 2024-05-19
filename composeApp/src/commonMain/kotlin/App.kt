import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import navigation.LandingDestination
import ui.landing.LandingScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(phone: Boolean = true) {
    MaterialTheme {
        Navigator(screen = LandingDestination(phone))
    }
}