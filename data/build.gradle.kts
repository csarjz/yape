plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.devtools.ksp)
}

android {
    namespace = "com.csarjz.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // okhttp3
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.interceptor)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)

    // testing
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)

    // modules
    implementation(project(mapOf("path" to ":domain")))
}
