package model.remote.repo

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

suspend inline fun <reified T> HttpResponse.safeApiCall(): ApiResponse<T> {
    return try {
        val responseBody = withContext(Dispatchers.Default) { this@safeApiCall.bodyAsText() }
        val data = Json.decodeFromString<T>(responseBody)
        ApiResponse.Success(data)
    } catch (e: SerializationException) {
        ApiResponse.Failure(e)
    } catch (e: Exception) {
        ApiResponse.Failure(e)
    }
}