package ui.landing

import androidx.compose.runtime.Composable

@Composable
fun LandingScreen(
    phone: Boolean = true,
    onLogInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    LandingContent(
        phone = phone,
        onLogInClick = onLogInClick,
        onSignUpClick = onSignUpClick,
    )
}
