package online.nsandroid.check_daily_activity.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import online.nsandroid.check_daily_activity.authenticate
import online.nsandroid.check_daily_activity.data.user.UserDataSource
import online.nsandroid.check_daily_activity.getSecretInfo
import online.nsandroid.check_daily_activity.security.hashing.HashingService
import online.nsandroid.check_daily_activity.signIn
import online.nsandroid.check_daily_activity.signUp
import online.nsandroid.security.token.TokenConfig
import online.nsandroid.security.token.TokenService

fun Application.configureRouting(
    userDataSource: UserDataSource,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig
) {
    routing {
        signIn(hashingService, userDataSource, tokenService, tokenConfig)
        signUp(hashingService, userDataSource)
        authenticate()
        getSecretInfo()
    }
}
