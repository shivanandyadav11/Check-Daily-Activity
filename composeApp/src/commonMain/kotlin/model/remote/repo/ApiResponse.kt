package model.remote.repo

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Failure(val error: Throwable) : ApiResponse<Nothing>()
}