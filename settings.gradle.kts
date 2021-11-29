rootProject.name = "http-server"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        }
    }
}


pluginManagement {
    plugins {
        kotlin("jvm") version "1.6.0"
        id("org.sonarqube") version "3.3"
    }
}