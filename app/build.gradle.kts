plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {

    namespace = ProjectSetting.PROJECT_NAME_SPACE
    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PROJECT_APP_ID
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK
        versionCode = ProjectSetting.PROJECT_VERSION_CODE
        versionName = ProjectSetting.PROJECT_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        ksp {
            arg("room.schemaLocation", "$projectDir/schemas") // If Using Ksp
        }

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

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of("17"))
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.work:work-runtime-ktx:2.8.1")
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation("io.reactivex.rxjava3:rxjava:3.1.6")

    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.room:room-rxjava3:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")

    implementation("com.google.code.gson:gson:2.10.1")

    implementation("io.insert-koin:koin-core:3.4.3")
    implementation("io.insert-koin:koin-android:3.4.3")
    implementation("io.insert-koin:koin-compose:1.0.4")
    implementation("io.insert-koin:koin-androidx-compose:3.4.6")

    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}