package com.runetopic

import com.runetopic.api.properties.JavConfigProperties
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.response.respondBytes
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun Application.module() {
    install(Koin) {
        modules(
            module {
                single { JavConfigProperties() }
            }
        )
    }

    val javaConfigProperties: JavConfigProperties by inject()

    routing {
        get("/jav_config.ws") {
            call.respondBytes {
                javaConfigProperties.fileAsBytes
            }
        }
        get("/gamepack.jar") {
            call.respondBytes { javaConfigProperties.gamePackAsBytes }
        }
        get("/browsercontrol_0.jar") {
            call.respondBytes { javaConfigProperties.browserControl0}
        }
        get("/browsercontrol_1.jar") {
            call.respondBytes { javaConfigProperties.browserControl1}
        }
    }
}

fun main() {
    embeddedServer(
        Netty,
        watchPaths = listOf("http-server"),
        module = Application::module,
        port = 8080
    ).start(wait = true)
}
