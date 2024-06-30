package ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject
import ui.action.ActionHandler
import ui.viewmodel.AuthViewModel
import ui.viewmodel.TaskViewModel

@Composable
fun HomeScreen(
    phone: Boolean = true,
    actionHandler: ActionHandler,
) {
    val viewModel: AuthViewModel = koinInject<AuthViewModel>()
    val taskViewModel: TaskViewModel = koinInject<TaskViewModel>()
    viewModel.getUserName()
    taskViewModel.getUserDate()

    val name = viewModel.name.collectAsState()
    val todayTasks = taskViewModel.todayTask.collectAsState()

    HomeContent(
        name = name,
        todayTasks = todayTasks,
        actionHandler = actionHandler
    )
}