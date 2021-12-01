import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
    kotlin("jvm")
    java
    application
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("org.sonarqube")
    jacoco
}

group = "org.com.runetopic"
version = "1.0-SNAPSHOT"

apply(plugin = "jacoco")
apply(plugin = "org.sonarqube")

jacoco {
    toolVersion = "0.8.7"
}

dependencies {
    implementation("com.runetopic.api:api:1.2.9-SNAPSHOT")
    implementation("io.ktor:ktor-server-core:1.6.6")
    implementation("io.ktor:ktor-server-netty:1.6.6")
    implementation("io.insert-koin:koin-core:3.1.4")
    implementation("io.insert-koin:koin-ktor:3.1.4")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
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

tasks.withType<JacocoReport> {
    dependsOn(tasks["test"])
    reports {
        xml.required.set(true)
    }
}

sonarqube {
    properties {
        property("sonar.projectKey", "runetopic_http-server")
        property("sonar.organization", "runetopic")
        property("sonar.sources", "src/main/")
        property("sonar.tests", "src/test/")
        property("sonar.exclusions", "src/generated/")
        property("sonar.jacoco.reportPath", "build/jacoco/test.exec")
        property("sonar.junit.reportsPath","build/test-results/test")
        property("sonar.core.codeCoveragePlugin","jacoco")
        property("sonar.verbose", "true")
        property("sonar.binaries" ,"build/classes/kotlin")
        property("sonar.java.binaries" ,"build/classes/java, build/classes/kotlin")
        property("sonar.dynamicAnalysis", "reuseReports")
    }
}