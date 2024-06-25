plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.room)
    id("com.google.devtools.ksp") version "1.9.23-1.0.19"
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

            // Room Database
            api(libs.room.runtime)
            implementation(libs.sqlite.bundled)
            implementation(libs.sqlite)
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
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
    add("kspJvm", libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}