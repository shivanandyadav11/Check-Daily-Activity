package online.nsandroid.check_daily_activity.security.token

interface TokenService {
    fun generate(config: TokenConfig, vararg tokenClaims: TokenClaim): String
}