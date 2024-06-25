package navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ui.home.HomeScreen
import ui.personal.PersonalContent

fun NavGraphBuilder.homeGraphDestination(
    navHostController: NavHostController,
) {
    composable(NavigationDestination.HomeDestination.route) {
        HomeScreen()
        //PersonalContent()
    }
}