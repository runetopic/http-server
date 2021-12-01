import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
    kotlin("jvm")
    java
    application
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "org.com.runetopic"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("io.ktor:ktor-server-core:1.6.6")
    implementation("io.ktor:ktor-server-netty:1.6.6")
    implementation("io.insert-koin:koin-core:3.1.4")
    implementation("io.insert-koin:koin-ktor:3.1.4")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
}

configurations.all {
    resolutionStrategy.cacheDynamicVersionsFor(1, "minutes")
}

application {
    mainClass.set("com.runetopic.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
}

plugins.withType<KotlinPluginWrapper> {
    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_17.majorVersion
            kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_17.majorVersion
            kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }
}