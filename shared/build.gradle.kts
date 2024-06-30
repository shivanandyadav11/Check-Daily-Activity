plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
    //Room
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin {
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    
    jvm()

    sourceSets.all {
        languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.datastore.preferences)
            implementation(libs.androidx.datastore.core)
            implementation(compose.runtime)

            //Room
            api(libs.room.runtime)
            implementation(libs.sqlite.bundled)

            api(libs.kotlinx.datetime)
            implementation(libs.serialization.json)
        }
        sourceSets.commonMain {
            kotlin.srcDir("build/generated/ksp/metadata")
        }

        androidMain.dependencies {
            implementation(libs.room.runtime.android)
        }
    }
}

android {
    namespace = "online.nsandroid.check_daily_activity.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

dependencies {
    // Room
    add("kspCommonMainMetadata", libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata" ) {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}