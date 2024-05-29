package navigation

sealed class NavigationDestination(val route: String) {
    data object LandingDestination: NavigationDestination("LandingDestination")
    data object LoginDestination: NavigationDestination("LoginDestination")
    data object SignUpDestination: NavigationDestination("SignUpDestination")
}
