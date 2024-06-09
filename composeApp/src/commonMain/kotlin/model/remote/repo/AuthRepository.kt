package model.remote.repo

import io.ktor.client.statement.HttpResponse
import model.remote.data.AuthRequest
import model.remote.network.AuthAPI

class AuthRepository(private val authAPI: AuthAPI) {
    suspend fun signIn(authRequest: AuthRequest): HttpResponse {
        return authAPI.signIn(authRequest = authRequest)
    }
}