package ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject
import ui.action.ActionHandler
import ui.viewmodel.AuthViewModel

@Composable
fun HomeScreen(
    phone: Boolean = true,
    actionHandler: ActionHandler,
) {
    val viewModel: AuthViewModel = koinInject<AuthViewModel>()
    viewModel.getUserName()

    val name = viewModel.name.collectAsState()

    HomeContent(name, actionHandler = actionHandler)
}