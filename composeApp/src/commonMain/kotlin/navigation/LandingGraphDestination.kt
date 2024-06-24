package navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ui.landing.LandingScreen

fun NavGraphBuilder.landingGraphDestination(
    navHostController: NavHostController,
) {
    composable(NavigationDestination.LandingDestination.route) {
        LandingScreen(
            onLogInClick = {
                navHostController.navigate(NavigationDestination.LoginDestination.route)
            },
            onSignUpClick =
            {
                navHostController.navigate(NavigationDestination.SignUpDestination.route)
            },
            userIsAlreadyAuthenticated = {
                navHostController.navigate(NavigationDestination.HomeDestination.route)
            }
        )
    }
}