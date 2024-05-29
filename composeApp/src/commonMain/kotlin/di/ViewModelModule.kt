package di

import org.koin.dsl.module
import ui.viewmodel.AuthViewModel

val viewModelModule = module {
    factory { AuthViewModel(get()) }
}