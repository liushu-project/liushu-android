// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.mozilla.rust-android-gradle:plugin:0.9.3")
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.22" apply false
    id("org.mozilla.rust-android-gradle.rust-android") version "0.9.3"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}