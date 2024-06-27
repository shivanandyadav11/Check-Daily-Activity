import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import navigation.ApplicationNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.core.Koin

@Composable
@Preview
fun App(phone: Boolean = true) {
    MaterialTheme {
        KoinContext {
            val navController = rememberNavController()
            ApplicationNavHost(navController)
        }
    }
}