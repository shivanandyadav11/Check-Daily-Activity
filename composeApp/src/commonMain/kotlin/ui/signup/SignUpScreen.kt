package ui.signup

import androidx.compose.runtime.Composable

@Composable
fun SignUpScreen(
    phone: Boolean = true,
    onCreateButtonClick: (String, String, String) -> Unit,
    onLoginTextClicked: () -> Unit,
) {
    SignUpContent(
        phone = phone,
        onCreateButtonClick = { userName, email, password ->
            run {
                onCreateButtonClick(userName, email, password)
            }
        },
        onLoginTextClicked = onLoginTextClicked,
    )
}