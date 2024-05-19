plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.serialization)
    application
}

group = "online.nsandroid.check_daily_activity"
version = "1.0.0"
application {
    mainClass.set("online.nsandroid.check_daily_activity.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.content.negotiatio)
    implementation(libs.ktor.server.serialization)
    implementation(libs.ktor.server.kmongo)
    implementation(libs.ktor.server.kmongo.coroutine)
    implementation(libs.ktor.server.commons.codec)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.authjwt)
    implementation(libs.ktor.server.call.log)

    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)

}