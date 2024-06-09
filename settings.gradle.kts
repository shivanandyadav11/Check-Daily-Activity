rootProject.name = "CheckDailyActivity"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        }
    }
}

include(":composeApp")
include(":server")
include(":shared")