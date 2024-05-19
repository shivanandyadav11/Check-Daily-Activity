package online.nsandroid.check_daily_activity.data.requests

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    val name: String,
    val email: String,
    val password: String,
)
