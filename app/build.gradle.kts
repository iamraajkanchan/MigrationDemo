plugins {
    id("com.android.application")
    kotlin("multiplatform")
}

android {
    namespace = "com.example.migrationdemo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.migrationdemo"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    android()
    sourceSets {
        val commonMain by getting {
            dependencies {}
        }
        val androidMain by getting {
            dependencies {
                implementation ("androidx.core:core-ktx:1.8.0")
                implementation ("androidx.appcompat:appcompat:1.6.1")
                implementation ("com.google.android.material:material:1.9.0")
                implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
            }
        }
    }
}

