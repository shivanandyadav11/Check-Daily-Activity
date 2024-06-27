package navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ui.login.LoginScreen

fun NavGraphBuilder.loginGraphDestination(
    navHostController: NavHostController,
) {
    composable(NavigationDestination.LoginDestination.route) {
        LoginScreen(
            onSuccessFullLogin = {
                navHostController.navigate(NavigationDestination.HomeDestination.route)
            },
            onSignUpTextClick = {
                navHostController.navigate(NavigationDestination.SignUpDestination.route)
            },
        )
    }
}