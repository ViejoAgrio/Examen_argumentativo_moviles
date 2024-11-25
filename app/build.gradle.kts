plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.kotlin.argumentativo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlin.argumentativo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)

    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)
    implementation(libs.glide.transformations)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.jetbrains.kotlinx.coroutines.android)

    // Fragment
    implementation(libs.androidx.fragment.ktx)

    // Activity
    implementation(libs.androidx.activity.ktx)

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

    implementation(libs.logging.interceptor)

    implementation (libs.androidx.databinding.runtime)
}