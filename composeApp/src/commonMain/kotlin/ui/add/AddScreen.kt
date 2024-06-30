package ui.add

import androidx.compose.runtime.Composable
import org.koin.compose.koinInject
import ui.viewmodel.TaskViewModel

@Composable
fun AddScreen(goBackToHome: () -> Unit) {
    val viewModel: TaskViewModel = koinInject<TaskViewModel>()
    AddContent(
        onCreateClick = {
            viewModel.saveNewTask(it)
            goBackToHome.invoke()
        }
    )
}