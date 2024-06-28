package navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import ui.add.AddScreen

fun NavGraphBuilder.addGraphDestination(
    navHostController: NavHostController,
) {
    composable(NavigationDestination.AddDestination.route) {
        AddScreen()
    }
}