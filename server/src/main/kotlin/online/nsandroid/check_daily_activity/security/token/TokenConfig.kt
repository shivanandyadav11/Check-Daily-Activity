package online.nsandroid.check_daily_activity.security.token

data class TokenConfig(
    val issuer: String,
    val audience: String,
    val expireIn: Long,
    val secret: String,
)
