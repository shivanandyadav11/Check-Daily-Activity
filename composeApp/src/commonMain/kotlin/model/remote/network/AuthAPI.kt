package model.remote.network

import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import model.remote.data.AuthRequest
import model.remote.network.ProvideClient.client

class AuthAPI {

    suspend fun signIn(authRequest: AuthRequest): HttpResponse {
        return client.post("$BASE_URL/signin") {
            contentType(ContentType.Application.Json)
            setBody(authRequest)
        }
    }


    companion object {
        const val BASE_URL = "http://localhost:5500" // TODO Review this and update it on successful server deployment.
    }
}