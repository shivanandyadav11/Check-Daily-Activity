import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import navigation.LandingDestination
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(phone: Boolean = true) {
    MaterialTheme {
        Navigator(screen = LandingDestination(phone))
    }
}