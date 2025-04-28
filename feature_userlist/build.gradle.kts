plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")

}

android {
    namespace = "com.debo.userexplorer.feature.userlist"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"  // Ensure this is the latest version compatible with Kotlin 1.8.10
        //kotlinCompilerVersion  = "1.8.0"  // Ensure this is set to your Kotlin version
    }
    hilt {
        enableAggregatingTask = false
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":data"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    hilt()
    hiltViewModel()
    compose()
    coilCompose()
    navigationCompose()
    lifecycleViewModelCompose()

    coroutinesTest()
    mockitoCore()
    mockitoKotlin()
    archCoreTesting()
    truth()
}