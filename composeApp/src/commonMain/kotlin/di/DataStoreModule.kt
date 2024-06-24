package di

import createDataStoreSource
import org.koin.dsl.module

val dataStoreModule = module {
    single {
        createDataStoreSource()
    }
}