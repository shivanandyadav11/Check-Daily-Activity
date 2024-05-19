package online.nsandroid.check_daily_activity.security.hashing

data class SaltedHash(
    val hash: String,
    val salt: String,
)