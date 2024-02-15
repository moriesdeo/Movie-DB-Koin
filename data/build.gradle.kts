@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.test.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 27

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "API_KEY", "\"d326fff658f490c8e464a6fa32642ca7\"")
        buildConfigField(
            "String",
            "TOKEN",
            "\"Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkMzI2ZmZmNjU4ZjQ5MGM4ZTQ2NGE2ZmEzMjY0MmNhNyIsInN1YiI6IjVjYjA0ZTA4MGUwYTI2MjZlOWM0MGI0ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vMmRQZI1OMkzkhIyv_FGy-GfdS5iWKpCLVPuaM-Ba5Q\""
        )
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(project(":domain"))
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.gson)
    implementation(libs.retrofit2)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}