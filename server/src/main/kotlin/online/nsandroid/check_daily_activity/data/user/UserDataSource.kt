package online.nsandroid.check_daily_activity.data.user

interface UserDataSource {
    suspend fun getUserByEmail(email: String): User?
    suspend fun insertNewUser(user: User): Boolean
}