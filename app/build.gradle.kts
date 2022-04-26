
plugins {
    id("com.android.application")
    kotlin("android")
}


android {
    compileSdk = 31

    defaultConfig {

        minSdk = 19
        targetSdk = 31

        versionCode = 1
        versionName = "1.0.0"
        applicationId = "fr.androidmakers.workshop"

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
    }

    sourceSets.named("main") {
        java.srcDir("src/main/kotlin")
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {

    implementation(libs.kotlin)

    testImplementation(libs.bundles.jUnit5)
    testImplementation(libs.bundles.elmyr)
    testImplementation(libs.assertJ)
}

tasks.withType<Test> {
    useJUnitPlatform()
}