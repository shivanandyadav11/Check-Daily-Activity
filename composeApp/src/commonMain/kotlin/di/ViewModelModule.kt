package di

import org.koin.dsl.module
import ui.viewmodel.AuthViewModel
import ui.viewmodel.TaskViewModel

val viewModelModule = module {
    factory { AuthViewModel(get(), get()) }
    factory { TaskViewModel(get()) }
}