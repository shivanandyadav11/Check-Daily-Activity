import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import navigation.ApplicationNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(phone: Boolean = true) {
    MaterialTheme {
        val navController = rememberNavController()
        ApplicationNavHost(navController)
    }
}