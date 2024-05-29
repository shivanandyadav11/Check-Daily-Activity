package navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ui.signup.SignUpScreen

fun NavGraphBuilder.signUpDetailGraphDestination(
    navHostController: NavHostController,
) {
    composable(NavigationDestination.SignUpDestination.route) {
        SignUpScreen(
            onCreateButtonClick = {
                    _, _, _ -> run {

            }
            },
            onLoginTextClicked = {
                navHostController.navigate(NavigationDestination.LoginDestination.route)
            }
        )
    }
}