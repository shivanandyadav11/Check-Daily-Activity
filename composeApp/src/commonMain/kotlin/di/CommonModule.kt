package di

import db.AppDatabase
import getRoomDatabase
import model.local.impl.SaveUserDataImpl
import model.local.repo.SaveUserData
import model.remote.repo.AuthRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import model.remote.network.AuthAPI

val commonModule = module {
    singleOf(::AuthAPI)
    factory { AuthRepository(get()) }
    factory { AuthAPI(get()) }
    single<SaveUserData> { SaveUserDataImpl(get(), get()) }
    single<AppDatabase> { getRoomDatabase() }
}