package di

import org.koin.dsl.module
import repo.MyRepository

val commonModule = module {
    factory { MyRepository() }
}