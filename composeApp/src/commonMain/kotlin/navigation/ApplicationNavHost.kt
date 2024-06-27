package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun ApplicationNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationDestination.LandingDestination.route
    ) {
        landingGraphDestination(
            navHostController = navController,
        )
        loginGraphDestination(
            navHostController = navController,
        )
        signUpDetailGraphDestination(
            navHostController = navController,
        )
        homeGraphDestination(
            navHostController = navController,
        )
    }
}