plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "eu.batomobile.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))

    api(libs.core.ktx)
    api(libs.coroutines)

    // Retrofit for HTTP requests
    api(libs.retrofit.core)
    api(libs.retrofit.gson.converter)
    api(libs.gson)

    // HTTP client
    api(libs.okhttp.core)
    api(libs.okhttp.logging.interceptor)

    // Logging
    api(libs.timber)

    // DI
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}