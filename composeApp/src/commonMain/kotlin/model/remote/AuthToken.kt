package model.remote

import kotlinx.serialization.Serializable


@Serializable
data class AuthToken(
    val token: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val name: String? = null,
)