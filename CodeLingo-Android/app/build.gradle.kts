plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "de.codelingo.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "de.codelingo.app"
        minSdk = 24          // Android 7.0 und neuer
        targetSdk = 35
        // Bei jedem GitHub-Build automatisch hochgezählt (sonst 1)
        versionCode = (System.getenv("GITHUB_RUN_NUMBER") ?: "1").toInt()
        versionName = "1.0.${System.getenv("GITHUB_RUN_NUMBER") ?: "0"}"
    }

    // Fester Schlüssel: Updates lassen sich über die alte Version installieren,
    // ohne sie zu deinstallieren – dein Lernfortschritt bleibt erhalten.
    signingConfigs {
        create("codelingo") {
            storeFile = file("codelingo.keystore")
            storeType = "pkcs12"
            storePassword = "codelingo"
            keyAlias = "codelingo"
            keyPassword = "codelingo"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("codelingo")
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("codelingo")
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
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-ktx:1.9.3")
    implementation("androidx.webkit:webkit:1.12.1")
}
