package di

import model.remote.repo.AuthRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import model.remote.network.AuthAPI

val commonModule = module {
    singleOf(::AuthAPI)
    factory { AuthRepository(get()) }
}