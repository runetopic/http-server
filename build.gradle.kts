plugins {
    kotlin("jvm") version "1.6.0"
    java
    application
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "org.com.runetopic"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.netty:netty-all:4.1.70.Final")
    implementation("com.runetopic.api:api:1.2.3-SNAPSHOT")
    implementation("io.insert-koin:koin-core:3.1.3")
}

application {
    mainClass.set("com.runetopic.ApplicationKt")
}

plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper> {
    java.sourceCompatibility = JavaVersion.VERSION_16
    java.targetCompatibility = JavaVersion.VERSION_16

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_16.majorVersion
            kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_16.majorVersion
            kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }
}