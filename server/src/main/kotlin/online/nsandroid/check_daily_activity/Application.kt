package online.nsandroid.check_daily_activity

import io.ktor.server.application.*
import online.nsandroid.check_daily_activity.data.user.MongoUserDataSource
import online.nsandroid.check_daily_activity.plugins.configureMonitoring
import online.nsandroid.check_daily_activity.plugins.configureRouting
import online.nsandroid.check_daily_activity.plugins.configureSecurity
import online.nsandroid.check_daily_activity.plugins.configureSerialization
import online.nsandroid.check_daily_activity.security.hashing.SHA256HashingService
import online.nsandroid.check_daily_activity.security.token.JwtTokenService
import online.nsandroid.check_daily_activity.security.token.TokenConfig
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}
/**
 *
 * First configure mongo db and setup the connection before running it.
 * For more help read this, https://www.mongodb.com/developer/languages/kotlin/mastering-kotlin-creating-api-ktor-mongodb-atlas/
 */
fun Application.module() {
    val mongoPw = MONGO_PW
    val dbName = "" // TODO - pass database name here
    val db = KMongo.createClient(
        connectionString = "mongodb+srv://<username>:<password>@<cluster-url>/<dbname>?retryWrites=true&w=majority" // TODO Configure before testing it.
    ).coroutine
        .getDatabase(dbName)
    val userDataSource = MongoUserDataSource(db)
    val tokenService = JwtTokenService()
    val tokenConfig = TokenConfig(
        issuer = environment.config.property("jwt.issuer").getString(),
        audience = environment.config.property("jwt.audience").getString(),
        expireIn = 365L * 1000L * 60L * 60L * 24L,
        secret = JWT_SECRET
    )

    val hashingService = SHA256HashingService()
    configureSecurity(tokenConfig)
    configureMonitoring()
    configureSerialization()
    configureRouting(userDataSource, hashingService, tokenService, tokenConfig)
}

const val JWT_SECRET = ""  // TODO - Before running pass jwt secret here.
const val MONGO_PW = "" // TODO - Add Mongodb password here.